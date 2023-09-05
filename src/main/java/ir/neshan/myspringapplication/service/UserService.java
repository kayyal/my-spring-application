package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.entities.User;
import ir.neshan.myspringapplication.mapper.UserMapper;
import ir.neshan.myspringapplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public User createUser(User user) {
        // TODO: ۰۵/۰۹/۲۰۲۳
        return null;
    }

    public User getUserByUsername(String username) {
        // TODO: ۰۵/۰۹/۲۰۲۳
        return null;
    }

    public boolean isOwnerOfRestaurant(User user, Long restaurantId) {
        // TODO: ۰۵/۰۹/۲۰۲۳
        return false;
    }
}

