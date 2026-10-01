package com.example.Personas;

public abstract class Persona {
    private String idPersona;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

    public Persona() {
    }

    public Persona(String idPersona, String nombre, String apellido, String dni, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    // --- REQUISITO AE2: Método abstracto ---
    public abstract String obtenerTipo();

    // --- REQUISITO AE2: Método concreto compartido ---
    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getIdPersona() { return idPersona; }
    public void setIdPersona(String idPersona) { this.idPersona = idPersona; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "idPersona='" + idPersona + '\'' +
                ", nombreCompleto='" + obtenerNombreCompleto() + '\'' +
                ", tipo='" + obtenerTipo() + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'';
    }
}