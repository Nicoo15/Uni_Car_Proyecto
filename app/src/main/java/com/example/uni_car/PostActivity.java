package com.example.uni_car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {

    private TextView mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        TextView usuario = findViewById(R.id.viewUsuario);
        TextView fecha = findViewById(R.id.viewFecha);
        TextView destino = findViewById(R.id.viewDestino);
        TextView hora = findViewById(R.id.viewHora);
        TextView origen = findViewById(R.id.ViewOrigen);
        TextView telfn = findViewById(R.id.numtelfono);

        usuario.setText(getIntent().getExtras().getString("usuario"));
        fecha.setText(getIntent().getExtras().getString("fecha"));
        destino.setText(getIntent().getExtras().getString("destino"));
        origen.setText(getIntent().getExtras().getString("origen"));
        hora.setText(getIntent().getExtras().getString("hora"));
        telfn.setText(getIntent().getExtras().getString("telfn"));


        mCancelButton = findViewById(R.id.buttonCancelpost);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.uni_car.PostActivity
                        .this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
    }
}

