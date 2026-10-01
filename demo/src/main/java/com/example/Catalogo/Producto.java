package com.example.Catalogo;

import com.example.Personas.Proveedor;

public class Producto implements Comparable<Producto> {
    private String idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(String idProducto, String nombre, String descripcion, double precio, Proveedor proveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public String getIdProducto() { return idProducto; }
    public void setIdProducto(String idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    // --- REQUISITO AE2: Orden Natural por Precio ---
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto='" + idProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=$" + precio +
                ", proveedor=" + (proveedor != null ? proveedor.getNombreEmpresa() : "N/A") +
                '}';
    }
}