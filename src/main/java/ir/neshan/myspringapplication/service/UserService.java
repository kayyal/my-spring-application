package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.entities.Restaurant;
import ir.neshan.myspringapplication.entities.User;
import ir.neshan.myspringapplication.exceptions.ResourceNotFoundException;
import ir.neshan.myspringapplication.mapper.UserMapper;
import ir.neshan.myspringapplication.repositories.RestaurantRepository;
import ir.neshan.myspringapplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RestaurantRepository restaurantRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean isOwnerOfRestaurant(User user, UUID restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            return restaurant.get().getOwner().equals(user);
        } else {
            throw new ResourceNotFoundException("The Restaurant is not found !");
        }
    }
}

