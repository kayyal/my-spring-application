package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.entities.Restaurant;
import ir.neshan.myspringapplication.mapper.RestaurantMapper;
import ir.neshan.myspringapplication.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantMapper restaurantMapper;

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
