package com.example.uni_car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;


public class Login extends AppCompatActivity {

    protected Button buttonlogin;
    protected TextView buttonRegister;
    public EditText editTextTextEmailAddress;

    public EditText editpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonRegister =findViewById(R.id.buttonRegister);
        editpassword =findViewById(R.id.editPassword);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);



        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Login
                        .this, RegisterActivity.class);
                intentRegister.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentRegister);

            }
        });

        buttonlogin = findViewById(R.id.buttonlogin);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(editTextTextEmailAddress.getText().toString().equals("")&&editpassword.getText().toString().equals("")){
                    Intent intent= new Intent (Login.this, RegisterActivity.class);
                    startActivity(intent);

                }else{
                    AccesoDatos.logUser(editTextTextEmailAddress.getText().toString(), editpassword.getText().toString(), Login.this );
                }

            }
        });



    }
}