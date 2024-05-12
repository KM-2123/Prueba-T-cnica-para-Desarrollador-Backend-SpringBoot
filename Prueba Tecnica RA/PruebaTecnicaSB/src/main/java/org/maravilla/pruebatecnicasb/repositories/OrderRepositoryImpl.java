package org.maravilla.pruebatecnicasb.repositories;

import org.maravilla.pruebatecnicasb.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order findById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null; // Devolver null si no se encuentra la orden
    }

    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            order.setId(nextId++);
        } else {
            // Si la orden ya tiene un ID, se asume que es una actualización
            deleteById(order.getId());
        }
        orders.add(order);
        return order;
    }

    @Override
    public void delete(Order order) {
        orders.remove(order);
    }

    @Override
    public void deleteById(Long id) {
        orders.removeIf(order -> order.getId().equals(id));
    }
}
