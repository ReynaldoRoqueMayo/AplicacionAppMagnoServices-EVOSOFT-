package com.example.appmagnoservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Fade;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.transition.MaterialContainerTransform;

public class OpcionesRegistro extends AppCompatActivity {

    Button btnCancel,btnContinuos;
    RadioButton rdbtnPerson,rdbtnBusiness;
//    RadioGroup rdGroupOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_registro);


        btnCancel = findViewById(R.id.btnOpcionesCancelar);
        btnContinuos = findViewById(R.id.btnOcionesContinuar);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(OpcionesRegistro.this, MainActivity.class);


                startActivity(intento);
            }
        });


        btnContinuos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rdbtnPerson=findViewById(R.id.rbtnPersona);
                rdbtnBusiness=findViewById(R.id.rbtnEmpresa);

                if(rdbtnPerson.isChecked()){

                    Intent intento= new Intent(OpcionesRegistro.this,RegistroActivity.class);
                    intento.putExtra("Tipo","Persona");
                    startActivity(intento);





                }else if (rdbtnBusiness.isChecked()){



                    Intent intent= new Intent(OpcionesRegistro.this,RegistroActivity.class);
                    intent.putExtra("Tipo","Empresa");
                    startActivity(intent);



                }else{

                    TextView tv = findViewById(R.id.snkBar);

                    Snackbar.make(
                            tv,
                            "Debe seleccionar una opción",
                            BaseTransientBottomBar.LENGTH_SHORT
                    )
                            .setBackgroundTint(getResources().getColor(R.color.Yellow))
                            .setTextColor(getResources().getColor(R.color.black))
                            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)

                            .show();

                }




            }
        });
    }
}