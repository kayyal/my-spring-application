package ir.neshan.myspringapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(MySpringApplication.class, args);
    }

}
