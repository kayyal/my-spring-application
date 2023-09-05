package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.OrderDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.entities.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

//    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDTO orderDto);

    OrderDTO toDto(Food food);
}
