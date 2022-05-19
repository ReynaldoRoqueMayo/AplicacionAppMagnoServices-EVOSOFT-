package com.example.appmagnoservices.adapter;


import android.app.AlertDialog;
import android.app.Dialog;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmagnoservices.R;
import com.example.appmagnoservices.model.Cita;


import java.text.DateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import io.grpc.Context;

public class CitaAdapter extends RecyclerAdapter<Cita,CitaAdapter.ViewHolder> {

    String fecha;
    ArrayList<Local> locales;


    public CitaAdapter(@NonNull FirestoreRecyclerOptions<Cita> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Cita model) {




        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<String> opcionesHorarios;

           
                TextInputEditText inpEdtDescripcion;



                opcionesHorarios = new ArrayList<>();
                frCitas= new ArrayList<>();





                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.dialog_editar_cita);
        
                dialog.setTitle("Editar Cita");

                Button  btnOkEdit = dialog.findViewById(R.id.btnConfirmEdit);
                Button  btnCancelEdit = dialog.findViewById(R.id.btnCancelEdit);

                AutoCompleteTextView acLocales = dialog.findViewById(R.id.acLocalEdit);
                AutoCompleteTextView acHorarios = dialog.findViewById(R.id.acHoraEdit);
                AutoCompleteTextView acServicios = dialog.findViewById(R.id.acServicioEdit);

                CalendarView calendarV = dialog.findViewById(R.id.calendarViewEdit);

                Calendar calendario = Calendar.getInstance();
          

                fecha=new SimpleDateFormat("dd/MM/yy").format(calendarV.getDate()).toString();


                try {
                    calendarV.setDate(new SimpleDateFormat("dd/MM/yy").parse(model.getFechaCita()).getTime(), true, true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                acLocales.setAdapter(arrayAdapterLocales);


                acServicios.setText(arrayAdapterServicios.getItem( arrayAdapterServicios.getPosition(model.getServicio())).toString(),false);
               

                frStore.collection("Cita").getFirestore().collectionGroup("MisCitas").addSnapshotListener(new EventListener<Snapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error!=null){

                            return;

                        }

                        for (Snapshot doc : value) {


                            Cita cta= new Cita(doc.getString("Estado"),doc.getString("FechaCita"),
                                    doc.getString("FechaCreacion"), doc.getString("Hora"),
                                    doc.getString("Servicio"),doc.getString("Sucursal"),doc.getString("Descripcion") );

                            frCitas.add(cta);
                        }

                    }
                });


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
                        }

                        arrayAdapterLocales.notifyDataSetChanged();

                        acHorarios.setAdapter(arrayAdapterHorarios);
                        Local localEncontrado = findLocal(model.getSucursal());

                        Log.i("LOCAL SELECCIONADO",localEncontrado.getId());


                        frStore.document(localEncontrado.get())(new EventListener<Snapshot>() {
                            @Override
                            public void onEvent(@Nullable Snapshot  value) {

                                if (error!=null){

                                    return;

                                }

                          
                                for (Snapshot doc : value) {
                                    if (doc.getString("Hora") != null) {


                                        int cantidadHora = 0;

                                        for(Cita cita : frCitas) {

                                            if(cita.getFechaCita().equals(model.getFechaCita()) && cita.getHora().equals(doc.getString("Hora").toString()) ){

                                                cantidadHora++;

                                            }
                                        }

                                        if(cantidadHora< (doc.getString()) || model.getHora().equals(doc.getString("Hora").toString()) ){
                                            opcionesHorarios.add(doc.getString("Hora"));
                                        }



                                    }
                                }

                             





                            }
                      


                    }
                });



                acLocales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String spOneSelected = adapterView.getItemAtPosition(i).toString();






                        Local localEncontrado = findLocal(spOneSelected);

                        Log.i("LOCAL SELECCIONADO",localEncontrado.getId());


                        frStore.collection("Locales").document(localEncontrado.getId().toString()).collection("Horarios").addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot  value, @Nullable FirebaseFirestoreException error) {

                                if (error!=null){

                                    return;

                                }


                                opcionesHorarios.clear();
                                for (Snapshot doc : value) {
                                    if (doc.getString("Hora") != null) {


                                        int cantidadHora = 0;

                           
                                        

                                     



                                    }
                                }

                                if(opcionesHorarios.contains(acHorarios.getText().toString())){

                                    acHorarios.setText(model.getHora(), false);

                                }else{

                                    acHorarios.setText("", false);

                                }




                            }
                        });






//                frStore.collection("Locales").document(localEncontrado.get()).("Horarios").SnapshotListener(new EventListener<Snapshot>() {
//
//                    @Override
//                    public void onEvent(@Nullable Snapshot  value) {
//
//                        if (error!=null){
//
//                            return;
//
//                        }
//
//             
//
//
//
//                        autoCompleteHorarios.setText("", false);
//
//                       
//
//
//
//
//                    }
//                });

                    }




                });













                //

                calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calView, int anio, int mes, int dia) {

                        Calendar cal= Calendar.getInstance();
                        cal.set(anio,mes,dia);
                       


                        Local localFind = findLocal(acLocales.getText().toString());



                                if (error!=null){

                                    return;

                                }
                                Local localFind = findLocal(acLocales.getText().toString());

                                opcionesHorarios.clear();
                                for (QueryDocumentSnapshot doc : value) {
                                    if (doc.getString("Hora") != null) {


                                        int cantidadHora = 0;

                                        for(Cita cita : frCitas) {

                                            if(cita.getFechaCita().equals(fecha) && cita.getHora().equals(doc.getString("Hora").toString()) ){

                                                cantidadHora++;

                                            
                                        }

                                        if(cantidadHora< Integer.parseInt(doc.getString("Cantidad").toString())  || (model.getHora().equals(doc.getString("Hora").toString()) && fecha.equals(model.getFechaCita()) && model.getSucursal().equals(localFind.Ubicacion)   ))   {
                                            opcionesHorarios.add(doc.getString("Hora"));
                                        }



                                    }
                                }

                                if(opcionesHorarios.contains(acHorarios.getText().toString())){

                          

                                }else{

                                    acHorarios.setText("", false);

                                }


                                acHorarios.clearFocus();

                                arrayAdapterHorarios.notifyDataSetChanged();






                            }
                        });


                    }
                });


                btnOkEdit.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {



                        Map<> dataActualizada = new HashMap<>();



                        dataActualizada.put("Fecha",fecha);
                        dataActualizada.put("Sucursal",acLocales.getText().toString());

                        dataActualizada.put("Estado","ACTIVO");

                        dataActualizada.put("Descripcion",inpEdtDescripcion.getText().toString());
                        DateFormat formatoDate = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                        dataActualizada.put("FechaC",formatoDate.format(calendario.getTime()).toString());



                    

                        dialog.cancel();
//                        Fr.getInstance().Reference("Student/3foBhgUVsWNdyS8ouc0HK1mgjy3")
//                               .child(studentModel).child("name").setValue(name_et.getText().String().trim());

                    }
                );

                btnCancelEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.cancel();;

                    
                ;


                dialog.show();

            }
        });
        holder.btnAnular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                

                alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete



                        Snapshots().getReference().delete();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
           


                    }
                });
                alert.show();




            }

        });
    }

    public Local findLocal(String ubicacionLocal) {

        for (Local local : locales) {
            if (local.Ubicacion.equals(ubicacionLocal)) {
                return local;
            }
        }
        return null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Servicio,Sucursal,FechaCita,HoraCita,Estado,FechaCreacion;
        Button btnEditar,btnAnular;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Servicio=itemView.findViewById(R.id.tvServicioItem);
            Sucursal=itemView.findViewById(R.id.tvSucursalItem);
          
            HoraCita=itemView.findViewById(R.id.tvHoraCitaItem);
            Estado=itemView.findViewById(R.id.tvEstadoItem);
            FechaCreacion=itemView.findViewById(R.id.tvFechaCreacionItem);
 





        }
    }


}
