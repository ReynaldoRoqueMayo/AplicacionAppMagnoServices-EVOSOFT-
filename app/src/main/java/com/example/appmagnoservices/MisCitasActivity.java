package com.example.appmagnoservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appmagnoservices.adapter.CitaAdapter;
import com.example.appmagnoservices.model.Cita;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Collection;

public class MisCitasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CitaAdapter citaAdapter;
 
   
    FirebaseUser firebaseUser;
    private FieldPath documentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_citas);

          

        recyclerView= findViewById(R.id.rvMisCitas);

        recyclerView.setLayoutManager(new LinearManager(this));
//       
        documentId = FieldPath.documentId();
        Query query = frStore.collection("Cita/"+firebaseUser.getUid()+"/MisCitas");




        FrOptions<Cita> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Cita>().setQuery(query,Cita.class).build();

   

        recyclerView.setAdapter(citaAdapter);

    }


    @Override
    protected void onStop() {
        super.onStop();
        citaAdapter.stopListening();
    }
}