package com.example.appmagnoservices.model;

import java.util.ArrayList;

public class Auto {
    public String Marca;
    public String id;
    public boolean seleccionado;
    public ArrayList<Modelo> modelos;


    public Auto(String marca, String id) {
        Marca = marca;
        this.id = id;
        seleccionado=false;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Modelo> modelos) {
        this.modelos = modelos;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public String toString() {
        return Marca;
    }




}
