package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.service.FoodService;
import ir.neshan.myspringapplication.service.UserService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<String> changeFoodPrice(@PathVariable Long foodId,
                                                  @RequestParam double newPrice,
                                                  @RequestParam String username) {
        return ResponseEntity
                .ok("Food price updated.");
    }
}
