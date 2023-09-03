package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.model.Food;
import ir.neshan.myspringapplication.model.User;
import ir.neshan.myspringapplication.service.FoodService;
import ir.neshan.myspringapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
public class FoodController {
    
    private final FoodService foodService;
    private final UserService userService;

    @GetMapping("/{restaurantId}")
    public List<Food> getFoodbyRestauratns(@PathVariable Long restaurantId) {
        return foodService.getFoodsByRestaurantId(restaurantId);
    }

    @PostMapping("/create")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    @PutMapping("/{id}")
    public void updateFood(@PathVariable Long id, @RequestBody Food updatedFood) {
        foodService.updateFood(updatedFood);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }

    @PutMapping("/{foodId}/change-price")
    public ResponseEntity<String> changeFoodPrice(
            @PathVariable Long foodId,
            @RequestParam double newPrice,
            @RequestParam String username) {
        User user = userService.getUserByUsername(username);
        Food food = foodService.getFoodById(foodId);

        if (food != null && foodService.isOwnerOfRestaurant(user, food.getRestaurant().getId())) {
            // change the price of the food item
            boolean priceChanged = foodService.updateFoodPrice(foodId, newPrice);
            if (priceChanged) {
                return ResponseEntity
                        .ok("Food price updated.");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to update food price.");
            }
        } else {
            // User is not the owner or the food item does not exist; return an unauthorized response
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Unauthorized: You are not the owner of this restaurant or the food item does not exist.");
        }
    }


}



