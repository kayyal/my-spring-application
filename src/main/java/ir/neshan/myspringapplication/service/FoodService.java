package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.dto.FoodDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.entities.User;
import ir.neshan.myspringapplication.mapper.FoodMapper;
import ir.neshan.myspringapplication.repositories.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        //todo
        return null;
    }

    public List<FoodDTO> findAllFood() {
        List<Food> foods = foodRepository.findAll();
        return foods.stream()
                .map(food -> foodMapper.toDto(food))
                .collect(Collectors.toList());
    }

    public Food createFood(Food food) {
        //todo
        return null;
    }

    public boolean updateFoodPrice(Long foodId, double newPrice) {
        /// TODO: ۰۵/۰۹/۲۰۲۳
        return false;
    }

    public void deleteFood(Long id) {
        //// TODO: ۰۵/۰۹/۲۰۲۳
    }

    public void updateFood(Food updatedFood) {

    }

    public boolean isOwnerOfRestaurant(User user, Long restaurantId) {
        //// TODO: ۰۵/۰۹/۲۰۲۳
        return false;
    }


    public Food getFoodById(Long foodId) {
        // // TODO: ۰۵/۰۹/۲۰۲۳
        return null;
    }

}
