package com.example.appmagnoservices.servicio;

import com.example.appmagnoservices.model.Persona;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DniService {

    @GET("v1/dni")
    Call<Persona> getPersona(@Query("numero") String numDni);

}
