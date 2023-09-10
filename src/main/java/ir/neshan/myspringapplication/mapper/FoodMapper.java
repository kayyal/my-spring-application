package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.FoodDTO;
import ir.neshan.myspringapplication.entities.Food;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FoodMapper {
    Food toEntity(FoodDTO foodDto);

    FoodDTO toDto(Food food);
}
