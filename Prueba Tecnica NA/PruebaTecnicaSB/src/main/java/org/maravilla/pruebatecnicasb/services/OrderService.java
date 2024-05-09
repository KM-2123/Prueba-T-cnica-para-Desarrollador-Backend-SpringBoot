package org.maravilla.pruebatecnicasb.services;

import org.maravilla.pruebatecnicasb.dto.OrderDTO;
import org.maravilla.pruebatecnicasb.models.Order;
import org.maravilla.pruebatecnicasb.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        return order != null ? mapToOrderDTO(order) : null;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = mapToOrderEntity(orderDTO);
        order = orderRepository.save(order);
        return mapToOrderDTO(order);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id);
        if (existingOrder != null) {
            existingOrder.setCustomerName(orderDTO.getCustomerName());
            // Actualizar otros campos si es necesario
            existingOrder = orderRepository.save(existingOrder);
            return mapToOrderDTO(existingOrder);
        }
        return null;
    }

    public boolean deleteOrder(Long id) {
        Order order = orderRepository.findById(id);
        if (order != null) {
            orderRepository.delete(order);
            return true;
        }
        return false;
    }

    private Order mapToOrderEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        // Mapear otros campos si es necesario
        return order;
    }

    private OrderDTO mapToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCustomerName(order.getCustomerName());
        // Mapear otros campos si es necesario
        return orderDTO;
    }
}
