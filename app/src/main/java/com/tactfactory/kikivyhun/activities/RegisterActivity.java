package com.tactfactory.kikivyhun.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.tactfactory.kikivyhun.R;

public class RegisterActivity extends AppCompatActivity {

    EditText firstname;
    EditText lastname;
    EditText login;
    EditText password;
    EditText passwordConfirm;
    CheckBox cgu;
    Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstname = (EditText) findViewById(R.id.editTextFirstname);
        lastname = (EditText) findViewById(R.id.editTextLastname);
        login = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        passwordConfirm = (EditText) findViewById(R.id.editTextPasswordValidation);
        cgu = (CheckBox) findViewById(R.id.checkBoxCGU);
        validate = (Button) findViewById(R.id.buttonRegister);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
            if (bundle.containsKey("LOGIN") && bundle.containsKey("PASSWORD")){
                this.login.setText(bundle.getString("LOGIN"));
                this.password.setText(bundle.getString("PASSWORD"));
            }
        }
    }
}
