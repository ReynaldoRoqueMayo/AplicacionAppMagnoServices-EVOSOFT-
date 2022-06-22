package com.example.appmagnoservices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import com.example.appmagnoservices.model.Cita;
import com.example.appmagnoservices.model.Local;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Tak;
import com.google.android.material.tetfield.TextInputEditText;
import com.google.irebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CentroCitasAcivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteLocales,autoCompleteHorarios,autoCompleteServicios;

    TextInputEditText inpEdtDescripcion;
    CalendarView calendarView;
    Button btnCompleteCita;
    String fecha;


    Calendar calendario ;
    FirebaseAuth firebaseAuth;

    private ArrayList<Local> locales;
    private ArrayList<String> opcionesHorarios;

    private ArrayList<Cita> frCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_citas_acivity);


        int local1LimiteCitas = 2;

        int local2LimiteCitas = 1;
        calendarView = findViewById(R.id.calendarView);
        
        calendario = Calendar.getInstance();
        calendarView.setMinDate(calendar.getTimeInMillis());

        frStore = FirebaseFirestore.getInstance();
        locales = new ArrayList<>();        

        frCitas= new ArrayList<>();

        inpEdtDescripcion = findViewById(R.id.edtDescripcion);

        autoCompleteLocales = findViewById(R.id.acLocal);
        
        autoCompleteServicios = findViewById(R.id.acServicio);
        btnCompleteCita = findViewById(R.id.btnRealizarCita);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        






        arrayAdapterLocales.setDropDownViewResource(R.layout.opcion_item);

        ArrayAdapter arrayAdapterHorarios = new ArrayAdapter(this, R.layout.opcion_item, opcionesHorarios);

        ArrayAdapter arrayAdapterServicios = new ArrayAdapter(this, R.layout.opcion_item, opcionesServicios);

        autoCompleteServicios.setText(arrayAdapterServicios.getItem(0).toString(), false);
        autoCompleteServicios.setAdapter(arrayAdapterServicios);

        autoCompleteLocales.setAdapter(arrayAdapterLocales);

        fr("Cita").getFrnew EventListener<Snapshot>() {
            @Override
            public void onEvent(@Nullable value, @Nullable error) {

                if (error!=null){

                    return;

                }

                for (QueryDocumentSnapshot doc : value) {


                        Cita cta= new Cita(doc.getString("Estado"),doc.get("FechaCita"),
                                doc.getString("FechaCreacion"), doc.get("Hora"),
                                doc.getString("Servicio"),doc.get("Sucursal"),doc.get("Descripcion") );

                        frCitas.add(cta);
                }

            }
        });




        autoCompleteLocales.setOnItemClickListener(new View.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String spOneSelected = adapterView.getItemAtPosition(i).toString();


                autoCompleteHorarios.setAdapter(arrayAdapterHorarios);



         




                frStore.collection("Locales").document(localEncontrado.get().toString()).collection("Horarios").Snapshot(new Listener<Snapshot>() {
                    @Override
                    public void onEvent(@Nullable QSnapshot  value, @Nullable FrException error) {

                        if (error!=null){

                            return;

                        }

                
                        for (Snapshot doc : value) {
                            if (doc.get("Hora") != null) {


                                int cantidadHora = 0;

                                for(Cita cita : frCitas) {

                                    if(cita.getFechaCita().equals(fecha) && cita.get().equals(doc.get("Hora").toString()) ){

                                        cantidadHora++;

                                    
                                }

                                if(cantidadHora< Integer.parseInt(doc.getString("Cantidad").toString())){
                                    opcionesHorarios.add(doc.getString("Hora"));
                                }



                            }
                        }

               



                    }
                });






//                frStore(localEncontrado).collection(new EventListener<napshot>() {
//
//                    @Override
//                    public void onEvent(@Nullable Snapshot  value, @Nullable FirestoreExcept error) {
//
//                        if (error!=null){
//
//                            return;
//
//                        }
//
//           
//                        for (Snapshot doc : value) {
//                            if (doc.getString("Hora") != null) {
//
//                                opcionesHorarios.add(doc.getString("Hora"));
//
//                            }
//                        }
//
//
//
//         
//
//
//
//
//                    }
//                })

            




        });

//
        frStore.collection("Locales").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot  value, @Nullable FirebaseFirestoreException error) {

                if (error!=null){

                    return;

                }

                locales.clear();
                for (QueryDocumentSnapshot doc : value) {
                    if (doc.getString("Ubicacion") != null) {

                        Local local= new Local(doc.getString("Ubicacion"),doc.getId().toString());

                        locales.add(local);

                    }
                

                arrayAdapterLocales.notifyDataSetChanged();

            }
        });








        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calView, int anio, int mes, int dia) {

                calendar.set(anio,mes,dia);
                fecha=sdf.format(calendar.getTime());
                if(!autoCompleteLocales.getText().toString().equals("")){


                    Local localFind = findLocal(autoCompleteLocales.getText().toString());



                    frStore.collection("Locales").document(localFind.getId().toString()).collection("Horarios").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                @Override
                                public void onEvent(@Nullable QuerySnapshot  value, @Nullable FirebaseFirestoreException error) {

                                    if (error!=null){

                                        return;

                                    }

                                  
                                    for (tSnapshot doc : value) {
                                        if (doc.getString("Hora") != null) {


                                            int cantidadHora = 0;

                                            for(Cita cita : frCitas) {

                                                if(cita.getFechaCita().equals(fecha) && cita.getHora().equals(doc.getString("Hora").toString()) ){

                                                    cantidadHora++;

                                                }
                                            }

                                            if(cantidadHora< Integer.parseInt(doc.getString("Cantidad").toString())){
                                               opcionesHorarios.add(doc.getString("Hora"));
                                            }



                                        }
                                    }

                                    autoCompleteHorarios.setText("", false);
                              




                                }
                            
                }


            }
        });

        btnCompleteCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.i("LOCALES",autoCompleteLocales.getText().toString());


                FirebaseUser usuario = firebaseAuth.getCurrentUser();
                DocumentReference documentReference = frStore.collection(usuario.getUid()).collection();
                Map<> dataCita = new HashMap<>();



                dataCita.put("FechaCita",fecha);
                dataCita.put("Sucursal",autoCompleteLocales.getText().toString());
                dataCita.put("Hora",autoCompleteHorarios.getText().toString());
                
             
                dataCita.put("Descripcion",inpEdtDescripcion.getText().toString());
                DateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                dataCita.put("FechaCreacion",formatoDate.format(calendario.getTime()).toString());


                dReference(dataCita).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Log.i("DATA CITA","Se creo la data de la cita");


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                );
         
            }
        });


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


}