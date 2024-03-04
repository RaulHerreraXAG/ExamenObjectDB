package org.example.domain;

import org.example.DAO;
import org.example.objectdb.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public void insertarCliente(Cliente cliente) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void getCliente(Long id) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                System.out.println("Información del cliente:");
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nombre: " + cliente.getNombrecliente());
                System.out.println("Total de ventas: " + cliente.getTotalventas());
                System.out.println("Estado: " + cliente.getEstado());
            } else {
                System.out.println("Cliente con ID " + id + " no encontrado.");
            }
        } finally {
            em.close();
        }
    }


    @Override
    public void listarMejoresClientes(Long cantidadMinimaVentas) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        List<Cliente> mejoresClientes = new ArrayList<>();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.totalventas > :cantidadMinimaVentas ORDER BY c.totalventas DESC", Cliente.class);
            query.setParameter("cantidadMinimaVentas", cantidadMinimaVentas);
            mejoresClientes = query.getResultList();

            System.out.println("Los mejores clientes con un minimo de " + cantidadMinimaVentas + " ventas:");
            for (Cliente cliente : mejoresClientes) {
                System.out.println(cliente);
            }
        } finally {
            em.close();
        }
    }

    public void estadisticas() {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            // Total de ventas entre todos los clientes
            TypedQuery<Long> totalVentasQuery = em.createQuery("SELECT SUM(c.totalventas) FROM Cliente c", Long.class);
            Long totalVentas = totalVentasQuery.getSingleResult();
            System.out.println("Total de ventas entre todos los clientes: " + totalVentas);

            // Promedio de ventas de los clientes activos
            TypedQuery<Double> promedioVentasQuery = em.createQuery("SELECT AVG(c.totalventas) FROM Cliente c WHERE c.estado = 'Activo'", Double.class);
            Double promedioVentas = promedioVentasQuery.getSingleResult();
            System.out.println("Promedio de ventas de los clientes activos: " + promedioVentas);

            // Cantidad de clientes inactivos que tienen total de ventas mayor a 0
            TypedQuery<Long> clientesInactivosQuery = em.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'Inactivo' AND c.totalventas > 0", Long.class);
            Long cantidadClientesInactivos = clientesInactivosQuery.getSingleResult();
            System.out.println("Cantidad de clientes inactivos que tienen total de ventas mayor a 0: " + cantidadClientesInactivos);
        } finally {
            em.close();
        }
    }




}





