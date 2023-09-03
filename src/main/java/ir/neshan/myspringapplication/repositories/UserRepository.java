package ir.neshan.myspringapplication.repositories;

import ir.neshan.myspringapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
