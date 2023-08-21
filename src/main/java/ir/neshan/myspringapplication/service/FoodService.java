package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.model.Food;
import ir.neshan.myspringapplication.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {
    List<Food> foods = new ArrayList<>();
    private long nextFoodId = 1;

    public List<Food> getFoodsbyRestaurantId(Long restaurantId) {
        return foods.stream()
                .filter(food -> food.restaurant().getId().equals(restaurantId))
                .collect(Collectors.toList());
    }

    public Food createFood(Food food) {
        // TODO
        return new Food(3243, "biff", 234, new Restaurant(23L, "delpazier", List.of()));
    }

    public void updateFood(Food updatedFood) {
        // TODO
    }

    public void deleteFood(Long nextFoodId) {
        // TODO
    }
}
