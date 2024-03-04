package org.example;

import org.example.domain.Cliente;
import org.example.domain.ClienteDAO;
import org.example.objectdb.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        // Insertar un nuevo cliente
        System.out.println("Metodo 1");
        System.out.println("--------------------------------------------------------------------------");
        Cliente nuevoCliente = new Cliente(13L, "Francisco", 0L, "Inactivo");
        clienteDAO.insertarCliente(nuevoCliente);
        System.out.println("Cliente insertado con éxito: " + nuevoCliente);


        // Obtener un cliente por su ID
        System.out.println("Metodo 2");
        System.out.println("--------------------------------------------------------------------------");
        Long idCliente = 124L; // Suponiendo que el ID del cliente que quieres obtener es 1
        clienteDAO.getCliente(idCliente);

        // Listar los mejores clientes
        System.out.println("Metodo 3");
        System.out.println("--------------------------------------------------------------------------");
        Long cantidadMejoresClientes = 5L; // Suponiendo que quieres obtener los mejores 5 clientes
        System.out.println("Listado de los mejores clientes:");
        clienteDAO.listarMejoresClientes(cantidadMejoresClientes);

        // Estadisticas
        System.out.println("Metodo 4");
        System.out.println("--------------------------------------------------------------------------");
        clienteDAO.estadisticas();



/*
        // Obtener lista de clientes de ejemplo
        List<Cliente> clientes = Data.insertarClientes();

        // Insertar cada cliente en la base de datos
        for (Cliente cliente : clientes) {
            clienteDAO.insertarCliente(cliente);
        }
    }
    */

    }
}

