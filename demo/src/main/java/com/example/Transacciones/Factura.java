package com.example.Transacciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.Personas.Cliente;
import com.example.Personas.Empleado;

public class Factura {
    private String numeroFactura;
    private LocalDate fechaEmision;
    private Cliente cliente;
    private Empleado empleado;
    private List<OfertaComercial> ofertas;
    private Pago pago;

    public Factura() {
        this.ofertas = new ArrayList<>();
    }

    public Factura(String numeroFactura, LocalDate fechaEmision, Cliente cliente, Empleado empleado, Pago pago) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.cliente = cliente;
        this.empleado = empleado;
        this.pago = pago;
        this.ofertas = new ArrayList<>();
    }

    public void agregarOferta(OfertaComercial oferta) {
        this.ofertas.add(oferta);
    }

    public double calcularTotalFactura() {
        double total = 0.0;
        for (OfertaComercial oferta : ofertas) {
            try {
                total += oferta.calcularTotal();
            } catch (OfertaSinItemsException e) {
                // Si la oferta no tiene ítems, suma 0.0
            }
        }
        return total;
    }

    public void mostrarFactura() {
        System.out.println("Factura Número: " + numeroFactura);
        System.out.println("Fecha de Emisión: " + fechaEmision);
        System.out.println("Cliente: " + (cliente != null ? cliente.obtenerNombreCompleto() : "N/A"));
        System.out.println("Empleado Gestor: " + (empleado != null ? empleado.obtenerNombreCompleto() + " - Cargo: " + empleado.getCargo() : "N/A"));
        System.out.println("Total a Pagar: $" + calcularTotalFactura());
    }

    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public List<OfertaComercial> getOfertas() { return ofertas; }
    public void setOfertas(List<OfertaComercial> ofertas) { this.ofertas = ofertas; }

    public Pago getPago() { return pago; }
    public void setPago(Pago pago) { this.pago = pago; }
}