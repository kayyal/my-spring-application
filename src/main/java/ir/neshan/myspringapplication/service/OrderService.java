package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.dto.OrderDTO;
import ir.neshan.myspringapplication.entities.Order;
import ir.neshan.myspringapplication.mapper.OrderMapper;
import ir.neshan.myspringapplication.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder;

    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<Order> findOrdersByRestaurantName(String restaurantName) {
        return orderRepository.findOrdersByRestaurantName(restaurantName);
    }
}
