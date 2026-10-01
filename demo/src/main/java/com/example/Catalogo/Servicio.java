package com.example.Catalogo;

import com.example.Personas.Empleado;

public class Servicio {
    private String idServicio;
    private String nombre;
    private double precio;
    private Empleado empleadoAfectado;

    public Servicio() {
    }

    public Servicio(String idServicio, String nombre, double precio, Empleado empleadoAfectado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precio = precio;
        this.empleadoAfectado = empleadoAfectado;
    }

    public String getIdServicio() { return idServicio; }
    public void setIdServicio(String idServicio) { this.idServicio = idServicio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Empleado getEmpleadoAfectado() { return empleadoAfectado; }
    public void setEmpleadoAfectado(Empleado empleadoAfectado) { this.empleadoAfectado = empleadoAfectado; }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio='" + idServicio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=$" + precio +
                '}';
    }
}