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
    Calendar calendar ;

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



actualizarFallidos();

        //timeador
        TimerTask task= new TimerTask() {
            @Override
            public void run() {


                Log.i("SE EJECUTO","MINUTO");
                String hora  = new SimpleDateFormat("HH:mm").format(calendar.getTime()).toString();

                if(hora.equals("8:00")){

                    actualizarFallidos();

                }

                if(hora.equals("8:30")){
                    actualizarFallidos();
                }
                if(hora.equals("9:30")){
                    actualizarFallidos();
                }
                if(hora.equals("10:00")){
                    actualizarFallidos();
                }
                if(hora.equals("10:30")){
                    actualizarFallidos();
                }
                if(hora.equals("11:00")){
                    actualizarFallidos();
                }
                if(hora.equals("11:30")){
                    actualizarFallidos();
                }
                if(hora.equals("12:00")){
                    actualizarFallidos();
                }
                if(hora.equals("12:30")){
                    actualizarFallidos();
                }
                if(hora.equals("01:00")){
                    actualizarFallidos();
                }
                if(hora.equals("01:30")){
                    actualizarFallidos();
                }
                if(hora.equals("02:00")){
                    actualizarFallidos();
                }
                if(hora.equals("02:30")){
                    actualizarFallidos();
                }
            }
        };



        Timer timer = new Timer("Timer");
        long delay = 60000;

        timer.schedule(task,0,delay);


    }


	public void actualizarFallidos() {


        frStore.collection("Cita/"+firebaseUser.getUid()+"/MisCitas").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error!=null){

                    return;

                }

                for (QueryDocumentSnapshot doc : value) {


                    DateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                    String FechaHoraActual = formatoDate.format(calendar.getTime()).toString();

                    String FechaHoraCita = doc.getString("FechaCita") +" "+doc.getString("Hora");



                    Date date1 = null;
                    Date date2 = null;
                    try {
                        date1 = formatoDate.parse(FechaHoraActual);
                        date2 = formatoDate.parse(FechaHoraCita);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Log.i("FECHA GUARDADA",date1.toString());
                    Log.i("FECHA GUARDADA",date2.toString());
                    if (date1.compareTo(date2)>0 && doc.getString("Estado").equals("ACTIVO") ){

                        doc.getReference().update("Estado","FALLIDO");

                    }





//                    Cita cta= new Cita(doc.getString("Estado"),doc.getString("FechaCita"),
//                            doc.getString("FechaCreacion"), doc.getString("Hora"),
//                            doc.getString("Servicio"),doc.getString("Sucursal"),doc.getString("Descripcion") );
//
//                    frCitas.add(cta);
                }

            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        citaAdapter.stopListening();
    }
}