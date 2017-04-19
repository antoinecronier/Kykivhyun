package com.tactfactory.kikivyhun.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.tactfactory.kikivyhun.R;
import com.tactfactory.kikivyhun.entities.Address;
import com.tactfactory.kikivyhun.entities.User;
import com.tactfactory.kikivyhun.utils.database.DatabaseManager;
import com.tactfactory.kikivyhun.utils.gps.UserLocationListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    public static final String LOGIN_KEY = "LOGIN_KEY";
    public static final String PASSWORD_KEY = "PASSWORD_KEY";

    private EditText login;
    private EditText password;
    private CheckBox passwordSave;
    private Button connection;
    private Button register;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RetrieveDataAsyncTask retrieve = new RetrieveDataAsyncTask();
//        retrieve.execute("http://www.mocky.io/v2/58ef7aad1000006f15ebc645");

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        passwordSave = (CheckBox) findViewById(R.id.checkBoxPasswordSave);
        connection = (Button) findViewById(R.id.buttonConnect);
        register = (Button) findViewById(R.id.buttonRegister);

        setWithPrefs();

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordSave.isChecked()) {
                    prefs.edit()
                            .putString(LOGIN_KEY, login.getText().toString())
                            .apply();
                    prefs.edit()
                            .putString(PASSWORD_KEY, password.getText().toString())
                            .apply();
                } else {
                    prefs.edit()
                            .remove(LOGIN_KEY)
                            .apply();
                    prefs.edit()
                            .remove(PASSWORD_KEY)
                            .apply();
                }

                if (login.getText().toString().equals("login") &&
                        password.getText().toString().equals("pass")) {
                    User currentUser = new User();
                    currentUser.setLogin("login");
                    currentUser.setPassword("pass");
                    currentUser.setLastname("lastname");
                    currentUser.setFirstname("firstname");

                    UserLocationListener.getInstance()
                            .setMyLocationListener(LoginActivity.this, currentUser);

                    startActivity(new Intent(LoginActivity.this,EventActivity.class));
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("LOGIN",LoginActivity.this.login.getText().toString());
                bundle.putString("PASSWORD",LoginActivity.this.password.getText().toString());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    private void setWithPrefs() {
        if (prefs.contains(LOGIN_KEY) && prefs.contains(PASSWORD_KEY)) {
            login.setText(prefs.getString(LOGIN_KEY, ""));
            password.setText(prefs.getString(PASSWORD_KEY, ""));
            passwordSave.setChecked(true);
        }else{
            login.setText("");
            password.setText("");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        setWithPrefs();
    }

    public static JSONArray getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);

        return new JSONArray(jsonString);
    }

    private class RetrieveDataAsyncTask extends AsyncTask<String, Void, JSONArray> {

        @Override
        protected JSONArray doInBackground(String... params) {
            JSONArray jsonObject = new JSONArray();
            try {
                jsonObject = getJSONObjectFromURL(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return jsonObject;
        }

        @Override
        protected void onPostExecute(JSONArray obj) {
            if (obj != null) {
                Log.d("JSON",obj.toString());
            }
        }
    }
}
