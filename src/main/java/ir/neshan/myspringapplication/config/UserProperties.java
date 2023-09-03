package ir.neshan.myspringapplication.config;

import ir.neshan.myspringapplication.model.User;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "users")
@Getter
@Configuration
public class UserProperties {
    private final List<User> userList = new ArrayList<>();
}