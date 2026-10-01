package com.example;

import com.example.Personas.Empleado;

public class Departamento {
    private String idDepartamento;
    private String nombre;
    private double presupuesto;
    private Empleado encargado;

    public Departamento() {
    }

    public Departamento(String idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public Departamento(String idDepartamento, double presupuesto, Empleado encargado) {
        this.idDepartamento = idDepartamento;
        this.presupuesto = presupuesto;
        this.encargado = encargado;
    }

    public String getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(String idDepartamento) { this.idDepartamento = idDepartamento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    public Empleado getEncargado() { return encargado; }
    public void setEncargado(Empleado encargado) { this.encargado = encargado; }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento='" + idDepartamento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}