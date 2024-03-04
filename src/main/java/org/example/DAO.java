package org.example;

import org.example.domain.Cliente;

import java.util.List;

public interface DAO<T> {

    void insertarCliente(Cliente cliente);

    void getCliente(Long id);

    void listarMejoresClientes(Long cantidadMinimaVentas);

    void estadisticas();
}
