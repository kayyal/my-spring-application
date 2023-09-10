package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FoodRepository extends JpaRepository<Food, UUID> {

    @Query("select f from Food f join f.restaurant r where r.name = :restaurantName")
    List<Food> findFoodsByRestaurantName(@Param("restaurantName") String restaurantName);

    List<Food> findByRestaurant(Restaurant restaurant);
}
