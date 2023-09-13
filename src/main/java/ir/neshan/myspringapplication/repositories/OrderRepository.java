package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("select o from Order o join o.food f join f.restaurant r where r.name = :restaurantName")
    List<Order> findOrdersByRestaurantName(@Param("restaurantName") String restaurantName);

    @Query("select o from Order o join o.user u join o.food f join f.restaurant r where u.username = :username and r.name = :restaurantName")
    List<Order> findOrdersByUsernameAndRestaurantName(@Param("username") String username,
                                                      @Param("restaurantName") String restaurantName);
}
