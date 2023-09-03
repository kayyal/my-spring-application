package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
