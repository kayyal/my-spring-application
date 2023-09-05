package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.OrderDto;
import ir.neshan.myspringapplication.model.Food;
import ir.neshan.myspringapplication.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Food food);
}
