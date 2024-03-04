package org.example.objectdb;

import org.example.domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Data {
    // Clase para la generacion de datos de ejemplo
    public static List<Cliente> insertarClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(12L, "Alejandro Robert", 0L, "Inactivo"));
        listaClientes.add(new Cliente(124L, "Antonio Ramirez", 2L, "Activo"));
        listaClientes.add(new Cliente(344L, "Javier Herrera", 5L, "Activo"));
        listaClientes.add(new Cliente(524L, "Marta Perez", 10L, "Inactivo"));
        listaClientes.add(new Cliente(544L, "Leo Hernandez", 20L, "Activo"));
        return listaClientes;
    }
}