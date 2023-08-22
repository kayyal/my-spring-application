package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private final List<Restaurant> restaurantsList = new ArrayList<>();
    private long nextRestaurantId = 1;

    public List<Restaurant> getAllRestaurants() {
        return restaurantsList;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant.setId(nextRestaurantId++);
        restaurantsList.add(restaurant);
        return restaurant;
    }

    public void deleteRestaurant(Long id) {
        restaurantsList.removeIf(restaurant -> restaurant.getId().equals(id));
    }


}
