package ir.neshan.myspringapplication.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private UserProperties userProperties;

    @Bean
    public UserDetailsService userDetailService(PasswordEncoder passwordEncoder) {

        List<UserDetails> userDetailsList = userProperties.getUserList()
                .stream()
                .map(user -> User.withUsername(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(user.getRole())
                        .build())
                .collect(Collectors.toList());

        return new InMemoryUserDetailsManager(userDetailsList);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeRequests()
                .requestMatchers("/foods/**", "/restaurants/**", "/users/**").hasRole("OWNER")
                .requestMatchers("/restaurants/**").hasRole("OWNER")
                .requestMatchers("/foods/**", "/orders/**").hasRole("USER")
                .requestMatchers("/foods/*/change-price").hasRole("OWNER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
