package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.model.Food;
import ir.neshan.myspringapplication.model.Restaurant;
import ir.neshan.myspringapplication.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {
    private final List<Food> foods = new ArrayList<>();
    private final List<Restaurant> restaurants; // List of restaurants
    private Long nextFoodId = 1L;

    public FoodService(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        return foods.stream()
                .filter(item -> item.getRestaurant().getId().equals(restaurantId))
                .collect(Collectors.toList());
    }

    public Food createFood(Food food) {
        Food tempFood = new Food(nextFoodId++, food.getName(), food.getRestaurant(), food.getPrice());
        foods.add(tempFood);
        return tempFood;
    }

    public boolean updateFoodPrice(Long foodId, double newPrice) {
        for (Food food : foods) {
            if (food.getId().equals(foodId)) {
                food.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public void deleteFood(Long id) {
        foods.removeIf(item -> item.getId().equals(id));
    }

    public void updateFood(Food updatedFood) {

    }

    public boolean isOwnerOfRestaurant(User user, Long restaurantId) {
        // Implement logic to check if the user is the owner of the restaurant
        // associated with restaurantId
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(restaurantId))
                .findFirst()
                .orElse(null);

        return restaurant != null && restaurant.getOwner().getId().equals(user.getId());
    }


    public Food getFoodById(Long foodId) {
        return foods.get(foodId.intValue());
    }

}
