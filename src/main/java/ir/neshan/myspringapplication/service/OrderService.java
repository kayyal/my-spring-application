package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.config.MQConfig;
import ir.neshan.myspringapplication.dto.GlobalMessage;
import ir.neshan.myspringapplication.dto.OrderDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.entities.Order;
import ir.neshan.myspringapplication.entities.User;
import ir.neshan.myspringapplication.exceptions.InvalidDataException;
import ir.neshan.myspringapplication.mapper.OrderMapper;
import ir.neshan.myspringapplication.repositories.FoodRepository;
import ir.neshan.myspringapplication.repositories.OrderRepository;
import ir.neshan.myspringapplication.repositories.RestaurantRepository;
import ir.neshan.myspringapplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final RabbitTemplate rabbitTemplate;

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


    @Transactional
    public void addFoodToOrder(UUID orderId, UUID foodId, UUID userId) throws InvalidDataException {
        Order order = orderRepository.getById(orderId);
        User user = userRepository.getById(userId);
        Food food = foodRepository.getById(foodId);

        // Check if the user owns the order and the food exists in the restaurant
        if (order.getUser().getId().equals(user.getId()) && food.getRestaurant().getMenu().contains(food)) {
            // Decrease the food count in the restaurant
            Integer newCount = food.getCount() - 1;
            food.setCount(newCount);

            // Add the food to the order
            order.getFood().add(food);

            // Update the entities in the repositories
            foodRepository.save(food);
            orderRepository.save(order);

            // Send the remaining food count to RabbitMQ
            GlobalMessage globalMessage = new GlobalMessage(food.getName(), newCount);
            rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY1, globalMessage);
        } else {
            throw new InvalidDataException();
        }
    }


}
