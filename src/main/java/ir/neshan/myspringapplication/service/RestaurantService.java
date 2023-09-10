package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.dto.RestaurantDTO;
import ir.neshan.myspringapplication.entities.Restaurant;
import ir.neshan.myspringapplication.mapper.RestaurantMapper;
import ir.neshan.myspringapplication.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository
                .findAll()
                .stream()
                .map(restaurantMapper::toDto)
                .collect(Collectors.toList());
    }

    public Restaurant createRestaurant(RestaurantDTO restaurantDTO) {
        return restaurantRepository.save(restaurantMapper.toEntity(restaurantDTO));

    }

    public void deleteRestaurant(UUID id) {
        restaurantRepository.deleteById(id);
    }


}
