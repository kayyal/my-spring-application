package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.FoodDto;
import ir.neshan.myspringapplication.model.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food toEntity(FoodDto foodDto);

    FoodDto toDto(Food food);
}
