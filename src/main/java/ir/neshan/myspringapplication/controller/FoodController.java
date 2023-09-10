package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.dto.FoodDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.service.FoodService;
import ir.neshan.myspringapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final UserService userService;

    @GetMapping("/{restaurantId}")
    public List<FoodDTO> getFoodbyRestauratns(@PathVariable UUID restaurantId) {
        return foodService.getFoodsByRestaurantId(restaurantId);
    }

    @PostMapping("/create")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }


    @PutMapping("/{id}")
    public ResponseEntity updateFoodById(@PathVariable("foodId") UUID foodId, @RequestBody FoodDTO foodDTO) {
        foodService.updateFoodByid(foodId, foodDTO);
        return ResponseEntity.ok("Food price updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFoodById(@PathVariable("foodId") UUID foodId) {
        if (!foodService.deleteFoodById(foodId)) {
            return ResponseEntity.status(404).body("The Food is not Found !");
        }
        return ResponseEntity.ok("The food has been deleted successfully !");

    }

    @PutMapping("/{foodId}/change-price")
    public ResponseEntity<String> changeFoodPrice(@PathVariable Long foodId,
                                                  @RequestParam double newPrice,
                                                  @RequestParam String username) {
        return ResponseEntity
                .ok("Food price updated.");
    }
}
