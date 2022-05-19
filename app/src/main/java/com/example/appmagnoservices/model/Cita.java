package com.example.appmagnoservices.model;

public class Cita {
    private String Estado;
    private String FechaCita;
    private String FechaCreacion;
    private String Hora;
    private String Servicio;
    private String Sucursal;
    private String Descripcion;


    public Cita() {
    }

    public Cita(String estado, String fechaCita, String fechaCreacion,
                String hora, String servicio, String sucursal,String descripcion) {



        Estado = estado;
        FechaCita = fechaCita;
        FechaCreacion = fechaCreacion;
        Hora = hora;
        Servicio = servicio;
        Sucursal = sucursal;
        Descripcion=descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCita() {
        return FechaCita;
    }

    public void setFechaCita(String fechaCita) {
        FechaCita = fechaCita;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String servicio) {
        Servicio = servicio;
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String sucursal) {
        Sucursal = sucursal;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
