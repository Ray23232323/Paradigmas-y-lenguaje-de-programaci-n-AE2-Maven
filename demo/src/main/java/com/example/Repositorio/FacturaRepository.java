package com.example.Repositorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.example.Transacciones.Imprimible;

public class FacturaRepository {
    private String nombreArchivo;

    public FacturaRepository(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // --- Guardar listado de resúmenes / facturas en archivo de texto ---
    public void guardarResumenes(List<Imprimible> listaImprimibles) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Imprimible item : listaImprimibles) {
                writer.println(item.obtenerResumen());
            }
            System.out.println("-> Datos guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // --- Leer la información guardada en el archivo de texto ---
    public List<String> leerResumenes() {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            System.out.println("-> Datos leidos exitosamente desde " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }
}