package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.FoodDTO;
import ir.neshan.myspringapplication.entities.Food;
import org.mapstruct.Mapper;

@Mapper
public interface FoodMapper {
//    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food toEntity(FoodDTO foodDto);

    FoodDTO toDto(Food food);
}
