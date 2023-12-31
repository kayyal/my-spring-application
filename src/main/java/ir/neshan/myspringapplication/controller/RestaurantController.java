package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.dto.RestaurantDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.service.FoodService;
import ir.neshan.myspringapplication.service.RestaurantService;
import ir.neshan.myspringapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurants")
@AllArgsConstructor
public class RestaurantController {
    private final UserService userService;
    private final FoodService foodService;
    private RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public RestaurantDTO createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        restaurantService.createRestaurant(restaurantDTO);
        return restaurantDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable UUID id) {
        restaurantService.deleteRestaurant(id);
    }

    @PostMapping("/{restaurantId}/add-food")
    public ResponseEntity<String> addFoodToRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody Food food,
            @RequestParam String username) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: You are not the owner of this restaurant.");

    }

    @PostMapping("/{restaurantId}/remove-food/{foodId}")
    public ResponseEntity<String> removeFoodFromRestaurant(@PathVariable Long restaurantId,
                                                           @PathVariable Long foodId,
                                                           @RequestParam String username) {

        return ResponseEntity
                .ok("Food removed from the restaurant's menu.");

    }

}
