package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
