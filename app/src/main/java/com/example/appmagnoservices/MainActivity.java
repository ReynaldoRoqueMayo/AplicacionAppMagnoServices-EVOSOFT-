package com.example.appmagnoservices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnRegistrar;
    EditText edtUsuario,edtPass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    
       






	
        btnLogin = findViewById(R.id.btnIngresar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(validate()){

                    fr.sign(edtUsuario.getText().toString(),edtPass.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(Task<AuthResult> task) {



                                    if (task)){






                                            DocumentReference docRef2=    firebaseAuth.get();


                                            docRef2.addSnapshotListener(MainActivity.this, new EventListener<Snapshot>() {

                                                @Override
                                                public void onEvent(@Nullable Snapshot Snapshot) {

                                                    String usuario=documentSnapshot.getString("Tipo");


                                                    if(usuario.equals("Cliente")){


                                                        Intent intento = new Intent(MainActivity.this,PrincipalActivity.class);
                                                        startActivity(intento);

                                                    }



                                                }
                                            });


                                    }{
//                                        String codeError = ((FirebaseAuthException)task.getException()).getErrorCode();
//                                        Toast.makeText(MainActivity.this, codeError, Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });



                }





            }
        });


        btnRegistrar= findViewById(R.id.btnCrearCuenta);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,OpcionesRegistro.class);

                startActivity(intent);


            }
        });

    }
}