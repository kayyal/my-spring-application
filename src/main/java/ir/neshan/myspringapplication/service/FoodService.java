package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.dto.FoodDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.entities.Restaurant;
import ir.neshan.myspringapplication.exceptions.ResourceNotFoundException;
import ir.neshan.myspringapplication.mapper.FoodMapper;
import ir.neshan.myspringapplication.repositories.FoodRepository;
import ir.neshan.myspringapplication.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodMapper foodMapper;

    public List<FoodDTO> getFoodsByRestaurantId(UUID restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));
        List<Food> foods = foodRepository.findByRestaurant(restaurant);
        return foods.stream()
                .map(foodMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<FoodDTO> findAllFood() {
        List<Food> foods = foodRepository.findAll();
        return foods.stream()
                .map(foodMapper::toDto)
                .collect(Collectors.toList());
    }

    public Food createFood(Food food) {
        Food savedFood = foodRepository.save(food);
        return savedFood;
    }

    public boolean updateFoodPrice(UUID foodId, double newPrice) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + foodId));
        food.setPricePerUnit(newPrice);
        foodRepository.save(food);
        return true;
    }

    public void updateFoodByid(UUID foodId, FoodDTO foodDTO) {
        foodRepository.findById(foodId).ifPresent(food -> {
            food.setName(foodDTO.getName());
            food.setCount(foodDTO.getCount());
            food.setPricePerUnit(foodDTO.getPricePerUnit());
            foodRepository.save(food);
        });
    }

    public Boolean deleteFoodById(UUID foodId) {
        if (foodRepository.existsById(foodId)) {
            foodRepository.deleteById(foodId);
            return true;
        }
        return false;
    }


    public Optional<Food> getFoodById(UUID foodId) {
        return foodRepository.findById(foodId);
    }

}
