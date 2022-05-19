package com.example.appmagnoservices;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {



    TextView tvNombreUsuario;
    Button btnCitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_principal);

   
        });

        btnCitas = findViewById(R.id.btnPrincipalCitas);

        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(PrincipalActivity.this,OpcionesCita.class);
                startActivity(intento);

            }
        });





    }
}