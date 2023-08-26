package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.model.Restaurant;
import ir.neshan.myspringapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final List<Restaurant> restaurants; // List of restaurants
    private Long nextUserId = 1L;

    @Autowired
    public UserService(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public User createUser(User user) {
        user.setId(nextUserId++);
        users.add(user);

        return user;
    }

    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean isOwnerOfRestaurant(User user, Long restaurantId) {
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(restaurantId))
                .findFirst()
                .orElse(null);

        return restaurant != null && restaurant.getOwner().getId().equals(user.getId());
    }
}

