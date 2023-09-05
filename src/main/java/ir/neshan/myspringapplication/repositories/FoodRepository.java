package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodRepository extends JpaRepository<Food, UUID> {

}
