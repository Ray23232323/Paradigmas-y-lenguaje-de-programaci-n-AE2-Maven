package com.example.Transacciones;

public interface Facturable {
    double calcularTotal() throws OfertaSinItemsException;
}