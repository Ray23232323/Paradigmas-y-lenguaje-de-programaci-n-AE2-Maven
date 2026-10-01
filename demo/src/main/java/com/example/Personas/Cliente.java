package com.example.Personas;

public class Cliente extends Persona {
    private String idCliente;
    private String categoria; // Ej: Regular, VIP, Corporativo

    public Cliente() {
        super();
    }

    public Cliente(String idPersona, String nombre, String apellido, String dni, String email, String telefono,
                   String idCliente, String categoria) {
        super(idPersona, nombre, apellido, dni, email, telefono);
        this.idCliente = idCliente;
        this.categoria = categoria;
    }

    // --- REQUISITO AE2: Implementación del método abstracto ---
    @Override
    public String obtenerTipo() {
        return "Cliente";
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", categoria='" + categoria + '\'' +
                ", " + super.toString() +
                '}';
    }
}