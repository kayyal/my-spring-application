package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.RestaurantDTO;
import ir.neshan.myspringapplication.entities.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RestaurantMapper {
    RestaurantDTO toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDTO restaurantDto);
}
