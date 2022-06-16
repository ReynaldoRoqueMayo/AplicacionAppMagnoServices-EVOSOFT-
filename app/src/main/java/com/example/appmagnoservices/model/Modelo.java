package com.example.appmagnoservices.model;

public class Modelo {


    public String id;
    public String Nombre;

    public Modelo(String id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }

}