package com.example.appmagnoservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionesCita extends AppCompatActivity {

    Button btnCrear,btnVerCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_cita);


        btnCrear = findViewById(R.id.btnCrearCitaOptions);
        btnVerCitas= findViewById(R.id.btnVerMisCitasOptions);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(OpcionesCita.this,CentroCitasAcivity.class);
                startActivity(intento);

            }
        });

        btnVerCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(OpcionesCita.this,MisCitasActivity.class);
                startActivity(intent);
            }
        });
    }
}