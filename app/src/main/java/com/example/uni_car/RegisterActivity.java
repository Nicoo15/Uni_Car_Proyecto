package com.example.uni_car;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private TextView mCancelButton;
    private Button mRegistroButton;
    public EditText email;
    private EditText passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //nombre = findViewById(R.id.editRegisterPersonName);
        email = findViewById(R.id.emailregister);
        passwd = findViewById(R.id.passwordregister);
        mRegistroButton = findViewById(R.id.buttonRegister);
        mRegistroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el email y la contraseÒa desde las cajas de texto
                String emaill = email.getText().toString().trim();
                String password = passwd.getText().toString().trim();


                //Verificamos que las cajas de texto no esten vacÌas
                if (TextUtils.isEmpty(emaill)) {
                    Toast.makeText(RegisterActivity.this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
                    return;
                }else if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Fallo al escribir  la contraseña", Toast.LENGTH_LONG).show();
                }else {
                    AccesoDatos.registrarusuario(emaill, password, RegisterActivity.this);
                }




            }
        });

        mCancelButton = findViewById(R.id.buttonCancel);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.uni_car.RegisterActivity
                        .this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }



        });


        }


    }

