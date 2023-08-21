package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private Long nextOrderId = 1L;

    public Order createOrder(Order order) {
        order.setId(nextOrderId);
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
