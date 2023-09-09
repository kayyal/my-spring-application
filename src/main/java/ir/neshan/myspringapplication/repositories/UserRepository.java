package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("select u from User u join u.orders o join o.food f where f.name = :foodName")
    List<User> findUsersByOrderedFood(@Param("foodName") String foodName);
}
