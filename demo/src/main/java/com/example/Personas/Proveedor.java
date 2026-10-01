package com.example.Personas;

public class Proveedor extends Persona {
    private String idProveedor;
    private String nombreEmpresa;
    private String rubro;

    public Proveedor() {
        super();
    }

    public Proveedor(String idPersona, String nombre, String apellido, String dni, String email, String telefono,
                     String idProveedor, String nombreEmpresa, String rubro) {
        super(idPersona, nombre, apellido, dni, email, telefono);
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.rubro = rubro;
    }

    // --- REQUISITO AE2: Implementación del método abstracto ---
    @Override
    public String obtenerTipo() {
        return "Proveedor";
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idProveedor='" + idProveedor + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", rubro='" + rubro + '\'' +
                ", " + super.toString() +
                '}';
    }
}