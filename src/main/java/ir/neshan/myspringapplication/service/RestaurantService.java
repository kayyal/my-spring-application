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

    public Restaurant createRestaurant(RestaurantDTO newRestaurant) {
        Restaurant savedRestaurant = restaurantRepository.save(restaurantMapper.toEntity(newRestaurant));
        RList<RestaurantDTO> cachedRestaurant = redissonClient.getList("restaurants");
        cachedRestaurant.add(restaurantMapper.toDto(savedRestaurant));
        return savedRestaurant;
    }

    public void updateRestaurant(RestaurantDTO updatedRestaurant) {
        // Update the restaurant in the database
        restaurantRepository.save(restaurantMapper.toEntity(updatedRestaurant));

        // Update the restaurant in the cache
        RList<RestaurantDTO> cachedRestaurants = redissonClient.getList("restaurants");

        // Find and update the existing restaurant in the cache
        for (RestaurantDTO cachedRestaurant : cachedRestaurants) {
            if (cachedRestaurant.getId() == updatedRestaurant.getId()) {
                cachedRestaurants.set(cachedRestaurants.indexOf(cachedRestaurant), updatedRestaurant);
                break;
            }
        }
    }

    public void deleteRestaurant(UUID id) {
        restaurantRepository.deleteById(id);
        RList<RestaurantDTO> cachedRestaurants = redissonClient.getList("restaurants");
        cachedRestaurants.removeIf(restaurantDTO -> restaurantDTO.getId() == id);
    }


}
