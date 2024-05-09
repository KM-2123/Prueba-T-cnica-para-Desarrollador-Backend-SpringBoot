package org.maravilla.pruebatecnicasb.repositories;

import org.maravilla.pruebatecnicasb.models.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order findById(Long id);
    Order save(Order order);
    void delete(Order order);

    void deleteById(Long id);
}
