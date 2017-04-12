package com.tactfactory.kikivyhun.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.tactfactory.kikivyhun.MyApplication;
import com.tactfactory.kikivyhun.R;
import com.tactfactory.kikivyhun.entities.User;
import com.tactfactory.kikivyhun.utils.gps.MyLocationListener;

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

        if (prefs.contains(LOGIN_KEY) && prefs.contains(PASSWORD_KEY)) {
            login.setText(prefs.getString(LOGIN_KEY, ""));
            password.setText(prefs.getString(PASSWORD_KEY, ""));
            passwordSave.setChecked(true);
        }

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

                    LocationManager locationManager = (LocationManager)
                            getSystemService(Context.LOCATION_SERVICE);

                    LocationListener locationListener = new MyLocationListener(LoginActivity.this, currentUser);
                    if (ActivityCompat.checkSelfPermission(
                                LoginActivity.this,
                                Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(
                                    LoginActivity.this,
                                    Manifest.permission.ACCESS_COARSE_LOCATION)
                                    == PackageManager.PERMISSION_GRANTED) {

                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
                    }


                    currentUser.setGps(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("USER",currentUser);

                    startActivity(new Intent(LoginActivity.this,EventActivity.class), bundle);
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
