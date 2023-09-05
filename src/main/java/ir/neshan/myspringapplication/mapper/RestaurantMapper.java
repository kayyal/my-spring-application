package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.RestaurantDTO;
import ir.neshan.myspringapplication.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDTO restaurantDto);
}
