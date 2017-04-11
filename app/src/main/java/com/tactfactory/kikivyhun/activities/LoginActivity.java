package com.tactfactory.kikivyhun.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.tactfactory.kikivyhun.R;

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

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        passwordSave = (CheckBox) findViewById(R.id.checkBoxPasswordSave);
        connection = (Button) findViewById(R.id.buttonConnect);
        register = (Button) findViewById(R.id.buttonRegister);

        if (prefs.contains(LOGIN_KEY) && prefs.contains(PASSWORD_KEY)){
            login.setText(prefs.getString(LOGIN_KEY,""));
            password.setText(prefs.getString(PASSWORD_KEY,""));
            passwordSave.setChecked(true);
        }

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordSave.isChecked()){
                    prefs.edit()
                            .putString(LOGIN_KEY,login.getText().toString())
                            .apply();
                    prefs.edit()
                            .putString(PASSWORD_KEY,password.getText().toString())
                            .apply();
                }else {
                    prefs.edit()
                            .remove(LOGIN_KEY)
                            .apply();
                    prefs.edit()
                            .remove(PASSWORD_KEY)
                            .apply();
                }

                if (login.getText().toString().equals("login") &&
                        password.getText().toString().equals("pass")){
                    startActivity(new Intent(LoginActivity.this,EventActivity.class));
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}
