package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.entities.Order;
import ir.neshan.myspringapplication.mapper.OrderMapper;
import ir.neshan.myspringapplication.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    public Order createOrder(Order order) {
        // TODO: ۰۵/۰۹/۲۰۲۳
        return null;
    }

    public List<Order> getAllOrders() {
        // TODO: ۰۵/۰۹/۲۰۲۳
        return null;
    }
}
