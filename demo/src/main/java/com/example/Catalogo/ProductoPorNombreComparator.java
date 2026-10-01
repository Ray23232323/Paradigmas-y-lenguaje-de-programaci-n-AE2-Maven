package com.example.Catalogo;

import java.util.Comparator;

public class ProductoPorNombreComparator implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}