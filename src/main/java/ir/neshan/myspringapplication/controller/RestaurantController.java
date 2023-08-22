package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.model.Restaurant;
import ir.neshan.myspringapplication.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);

    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
    }


}
