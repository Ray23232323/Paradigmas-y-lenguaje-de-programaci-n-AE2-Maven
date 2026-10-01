package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Catalogo.Producto;
import com.example.Catalogo.ProductoPorNombreComparator;
import com.example.Personas.Cliente;
import com.example.Personas.Empleado;
import com.example.Personas.Persona;
import com.example.Personas.Proveedor;
import com.example.Repositorio.FacturaRepository;
import com.example.Transacciones.Imprimible;
import com.example.Transacciones.OfertaComercial;
import com.example.Transacciones.OfertaSinItemsException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   DEMOSTRACIÓN INTEGRAL AE2 - PARADIGMAS II     ");
        System.out.println("==================================================\n");

        // ----------------------------------------------------
        // 1. POLIMORFISMO Y CLASE ABSTRACTA PERSONA
        // ----------------------------------------------------
        System.out.println("--- 1. POLIMORFISMO EN PERSONA ---");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Cliente("P1", "Maximo", "Marquez", "12345678", "maxi@email.com", "3754-1111", "C001", "VIP"));
        personas.add(new Empleado("P2", "Ana", "Gomez", "87654321", "ana@email.com", "3754-2222", "E001", "Desarrolladora", 850000.0, LocalDate.now(), new Departamento("D1", "Sistemas")));
        personas.add(new Proveedor("P3", "Carlos", "Lopez", "11223344", "carlos@email.com", "3754-3333", "PR01", "Tech Supplies SRL", "Hardware"));

        for (Persona p : personas) {
            System.out.println("Nombre: " + p.obtenerNombreCompleto() + " | Tipo: " + p.obtenerTipo());
        }
        System.out.println();

        // ----------------------------------------------------
        // 2. ORDENAMIENTO (COMPARABLE Y COMPARATOR)
        // ----------------------------------------------------
        System.out.println("--- 2. ORDENAMIENTO DE PRODUCTOS ---");
        Proveedor prov = (Proveedor) personas.get(2);
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("PROD1", "Teclado Mecanico", "RGB Switch Red", 45000.0, prov));
        productos.add(new Producto("PROD2", "Monitor 24", "144Hz Full HD", 180000.0, prov));
        productos.add(new Producto("PROD3", "Mouse Gamer", "16000 DPI", 25000.0, prov));

        System.out.println("> Lista Original:");
        for (Producto p : productos) System.out.println("  " + p);

        // Orden Natural por Precio (Comparable)
        Collections.sort(productos);
        System.out.println("\n> Orden Natural por Precio (Comparable):");
        for (Producto p : productos) System.out.println("  " + p);

        // Orden Alternativo por Nombre (Comparator)
        Collections.sort(productos, new ProductoPorNombreComparator());
        System.out.println("\n> Orden Alternativo por Nombre (Comparator):");
        for (Producto p : productos) System.out.println("  " + p);
        System.out.println();

        // ----------------------------------------------------
        // 3. EXCEPCIÓN PROPIA DEL DOMINIO
        // ----------------------------------------------------
        System.out.println("--- 3. EXCEPCIÓN PROPIA (OfertaSinItemsException) ---");
        Cliente cliente = (Cliente) personas.get(0);
        Empleado empleado = (Empleado) personas.get(1);

        OfertaComercial ofertaVacia = new OfertaComercial("OFT-EMPTY", LocalDate.now(), cliente, empleado);
        try {
            System.out.println("Intentando calcular total de una oferta sin items...");
            ofertaVacia.calcularTotal();
        } catch (OfertaSinItemsException e) {
            System.out.println("EXCEPCIÓN CAPTURADA CORRECTAMENTE: " + e.getMessage());
        }
        System.out.println();

        // ----------------------------------------------------
        // 4. INTERFACES MULTIPLES Y PERSISTENCIA DE DATOS
        // ----------------------------------------------------
        System.out.println("--- 4. MULTIPLES INTERFACES Y PERSISTENCIA ---");
        OfertaComercial ofertaValida = new OfertaComercial("OFT-2026", LocalDate.now(), cliente, empleado);
        ofertaValida.agregarProducto(productos.get(0));
        ofertaValida.agregarProducto(productos.get(1));

        List<Imprimible> listaParaImprimir = new ArrayList<>();
        listaParaImprimir.add(ofertaValida);

        // Persistencia mediante FacturaRepository
        FacturaRepository repository = new FacturaRepository("datos_resumenes.txt");
        
        System.out.println("Guardando resumenes en el archivo...");
        repository.guardarResumenes(listaParaImprimir);

        System.out.println("\nLeyendo resumenes guardados del archivo:");
        List<String> contenidoLeido = repository.leerResumenes();
        for (String linea : contenidoLeido) {
            System.out.println("  [ARCHIVO]: " + linea);
        }

        System.out.println("\n==================================================");
        System.out.println("   EJECUCIÓN COMPLETADA CON ÉXITO                ");
        System.out.println("==================================================");
    }
}