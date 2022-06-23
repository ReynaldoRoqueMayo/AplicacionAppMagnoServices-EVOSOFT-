package com.example.appmagnoservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    Button btnCancelRegister,btnContinuosRegister;
    EditText edtEmail,edtPass,edtNombre,edtApellido,edtTelefono,edtDni;


    AwesomeValidation awesomeValidation;
    FirebaseAuth firebaseAuth;

    FirebaseFirestore frStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        CheckBox checkBoxPoliticas;

        TextView tvPoliticas;
    
        CheckBox checkBoxProteccionDatos;
        TextView tvProteccion;
    
    
    
    
       String email = edtEmail.getText().toString();
                    String pass  =edtPass.getText().toString();
    
                    String telefono = edtTelefono.getText().toString();
                    String dni = edtDni.getText().toString();
    
    
                    if(!checkBoxPoliticas.isChecked()) {
    
    
    
                        tvPoliticas.setError("Se requiere aceptar los terminos de uso");


;


        btnCancelRegister = findViewById(R.id.btnCancelarRegistro);
        btnContinuosRegister = findViewById(R.id.btnContinuarRegisro);
        edtEmail=findViewById(R.id.edtCorreoRegistro);
        edtPass=findViewById(R.id.edtPassRegistro);
        edtNombre= findViewById(R.id.edtNombreRegistro);
        edtApellido= findViewById(R.id.edtApellidoRegistro);
        edtTelefono= findViewById(R.id.edtCelularRegistro);
        edtDni= findViewById(R.id.edtDniRegistro);



        String tipo = getIntent().getStringExtra("Tipo");


        if(tipo.equals("Empresa")){


            EditText edtRuc = findViewById(R.id.inpRUC);
            edtRuc.setVisibility(View.VISIBLE);
            EditText edtRazonSocial = findViewById(R.id.inpRazonSocial);
            edtRazonSocial.setVisibility(View.VISIBLE);
        







        btnCancelRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Intent intento = new Intent(RegistroActivity.this,OpcionesRegistro.class);
                startActivity(intento);


            }
        );


        btnContinuosRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String email = edtEmail.getText().toString();
                String pass  =edtPass.getText().toString();
    
                String apellido = edtApellido.getText().toString();
                String telefono = edtTelefono.getText().toString();
                String dni = edtDni.getText().toString();

                if (awesomeValidation.validate()){

                    frAuth.create(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()){

                       

                                DocumentReference documentReference = document(user.get());
                                Map<> dataUser = new HashMap<>();
                                dataUser.put("Nombre",nombre);
                                dataUser.put("Apellido",apellido);
                                dataUser.put("Telefono",telefono);
                                dataUser.put("Dni",dni);
                                dataUser.put("Tipo","Cliente");

                                dReference.set(dataUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        Log.i("DATA USER","Se creo la data del usuario");

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                    }
                                };


                                    Toast.makeText(RegistroActivity.this, "Usuario Creado Exitosamente!", Toast.LENGTH_SHORT).show();



                                
                            }else{


                            
                        }
                    });

                }else{

                    Toast.makeText(RegistroActivity.this,"Completa los datos",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}