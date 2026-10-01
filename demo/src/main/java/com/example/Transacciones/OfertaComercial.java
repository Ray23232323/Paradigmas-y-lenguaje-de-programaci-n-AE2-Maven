package com.example.Transacciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.Catalogo.Producto;
import com.example.Catalogo.Servicio;
import com.example.Personas.Cliente;
import com.example.Personas.Empleado;

public class OfertaComercial implements Facturable, Imprimible {
    private String idOferta;
    private LocalDate fechaCreacion;
    private Cliente cliente;
    private Empleado empleado;
    private List<Producto> listaProductos;
    private List<Servicio> listaServicios;

    public OfertaComercial() {
        this.listaProductos = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
    }

    public OfertaComercial(String idOferta, LocalDate fechaCreacion, Cliente cliente, Empleado empleado) {
        this.idOferta = idOferta;
        this.fechaCreacion = fechaCreacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.listaProductos = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
    }

    public String getIdOferta() { return idOferta; }
    public void setIdOferta(String idOferta) { this.idOferta = idOferta; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public List<Producto> getListaProductos() { return listaProductos; }
    public void setListaProductos(List<Producto> listaProductos) { this.listaProductos = listaProductos; }

    public List<Servicio> getListaServicios() { return listaServicios; }
    public void setListaServicios(List<Servicio> listaServicios) { this.listaServicios = listaServicios; }

    public void agregarProducto(Producto producto) {
        this.listaProductos.add(producto);
    }

    public void agregarServicio(Servicio servicio) {
        this.listaServicios.add(servicio);
    }

    // --- REQUISITO AE2: Excepción propia del dominio ---
    @Override
    public double calcularTotal() throws OfertaSinItemsException {
        if (listaProductos.isEmpty() && listaServicios.isEmpty()) {
            throw new OfertaSinItemsException("La oferta comercial " + idOferta + " no posee productos ni servicios asociados.");
        }

        double total = 0.0;
        for (Producto p : listaProductos) {
            total += p.getPrecio();
        }
        for (Servicio s : listaServicios) {
            total += s.getPrecio();
        }
        return total;
    }
    
    @Override
    public String obtenerResumen() {
        double totalCalculado = 0.0;
        try {
            totalCalculado = calcularTotal();
        } catch (OfertaSinItemsException e) {
            totalCalculado = 0.0;
        }

        return "Oferta [" + idOferta + "] - Cliente: " + 
               (cliente != null ? cliente.obtenerNombreCompleto() : "N/A") + 
               " - Total Items: " + (listaProductos.size() + listaServicios.size()) + 
               " - Total: $" + totalCalculado;
    }

    @Override
    public String toString() {
        return "OfertaComercial{" +
                "idOferta='" + idOferta + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", cliente=" + (cliente != null ? cliente.obtenerNombreCompleto() : "N/A") +
                ", empleado=" + (empleado != null ? empleado.obtenerNombreCompleto() : "N/A") +
                ", totalProductos=" + listaProductos.size() +
                ", totalServicios=" + listaServicios.size() +
                '}';
    }
}