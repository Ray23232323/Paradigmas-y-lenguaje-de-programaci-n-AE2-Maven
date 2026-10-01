package com.example.Personas;

import com.example.Departamento;
import java.time.LocalDate;

public class Empleado extends Persona {
    private String idEmpleado;
    private String cargo;
    private double salario;
    private LocalDate fechaContratacion;
    private Departamento departamento;

    public Empleado() {
        super();
    }

    public Empleado(String idPersona, String nombre, String apellido, String dni, String email, String telefono,
                    String idEmpleado, String cargo, double salario, LocalDate fechaContratacion, Departamento departamento) {
        super(idPersona, nombre, apellido, dni, email, telefono);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.departamento = departamento;
    }

    // --- REQUISITO AE2: Implementación del método abstracto ---
    @Override
    public String obtenerTipo() {
        return "Empleado";
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", fechaContratacion=" + fechaContratacion +
                ", departamento=" + (departamento != null ? departamento.getNombre() : "N/A") +
                ", " + super.toString() +
                '}';
    }
}