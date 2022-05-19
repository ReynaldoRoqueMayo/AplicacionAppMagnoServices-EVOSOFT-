package com.example.appmagnoservices.model;

public class Local {

    public String Ubicacion;
    public String id;


    public Local() {
    }

    public Local(String ubicacion, String id) {
        Ubicacion = ubicacion;
        this.id = id;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Ubicacion;
    }
}
