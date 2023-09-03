package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
