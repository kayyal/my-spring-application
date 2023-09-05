package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {
}
