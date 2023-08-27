package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.model.Food;
import ir.neshan.myspringapplication.model.Restaurant;
import ir.neshan.myspringapplication.model.User;
import ir.neshan.myspringapplication.service.FoodService;
import ir.neshan.myspringapplication.service.RestaurantService;
import ir.neshan.myspringapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final UserService userService;
    private final FoodService foodService;
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService, UserService userService, FoodService foodService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
        this.foodService = foodService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);

    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @PostMapping("/{restaurantId}/add-food")
    public ResponseEntity<String> addFoodToRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody Food food,
            @RequestParam String username) {
        User user = userService.getUserByUsername(username);

        if (foodService.isOwnerOfRestaurant(user, restaurantId)) {
            // User is the owner of the restaurant; add the food item
            // to the restaurant's menu
            // Implement logic to add the food item to the menu
            return ResponseEntity.ok("Food added to the restaurant's menu.");
        } else {
            // User is not the owner; return an unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: You are not the owner of this restaurant.");
        }
    }

    @PostMapping("/{restaurantId}/remove-food/{foodId}")
    public ResponseEntity<String> removeFoodFromRestaurant(@PathVariable Long restaurantId,
                                                           @PathVariable Long foodId,
                                                           @RequestParam String username) {
        User user = userService.getUserByUsername(username);
        if (foodService.isOwnerOfRestaurant(user, restaurantId)) {

            return ResponseEntity
                    .ok("Food removed from the restaurant's menu.");
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Unauthorized: You are not the owner of this restaurant.");
        }

    }

}
