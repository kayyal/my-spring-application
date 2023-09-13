package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.dto.OrderDTO;
import ir.neshan.myspringapplication.entities.Order;
import ir.neshan.myspringapplication.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
