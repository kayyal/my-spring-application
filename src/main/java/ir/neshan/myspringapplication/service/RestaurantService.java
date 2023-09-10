package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.dto.RestaurantDTO;
import ir.neshan.myspringapplication.entities.Restaurant;
import ir.neshan.myspringapplication.mapper.RestaurantMapper;
import ir.neshan.myspringapplication.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final RedissonClient redissonClient;

    public List<RestaurantDTO> getAllRestaurants() {
        RList<RestaurantDTO> cashedRestaurants = redissonClient.getList("restaurants");
        List<RestaurantDTO> cachedData = cashedRestaurants.readAll();
        if (cachedData.isEmpty()) {
            List<RestaurantDTO> restaurantsFromDB = restaurantRepository
                    .findAll()
                    .stream()
                    .map(restaurantMapper::toDto)
                    .collect(Collectors.toList());
            cashedRestaurants.addAll(restaurantsFromDB);
            return restaurantsFromDB;
        } else {
            return cachedData;
        }

    }

    public Restaurant createRestaurant(RestaurantDTO restaurantDTO) {
        return restaurantRepository.save(restaurantMapper.toEntity(restaurantDTO));

    }

    public void deleteRestaurant(UUID id) {
        restaurantRepository.deleteById(id);
    }


}
