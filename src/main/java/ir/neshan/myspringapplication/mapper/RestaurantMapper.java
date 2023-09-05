package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.RestaurantDto;
import ir.neshan.myspringapplication.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDto restaurantDto);
}
