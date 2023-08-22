package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {
    private final List<Food> foods = new ArrayList<>();
    private Long nextFoodId = 1L;

    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        return foods.stream()
                .filter(item -> item.restaurant().getId().equals(restaurantId))
                .collect(Collectors.toList());
    }

    public Food createFood(Food food) {
        Food tempFood = new Food(nextFoodId++, food.name(), food.price(), food.restaurant());
        foods.add(tempFood);
        return tempFood;
    }

    public void updateFood(Food updatedFood) {
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            if (food.id().equals(updatedFood.id())) {
                foods.set(i, updatedFood);
                break;
            }
        }
    }

    public void deleteFood(Long id) {
        foods.removeIf(item -> item.id().equals(id));
    }
}
