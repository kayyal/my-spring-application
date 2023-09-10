package ir.neshan.myspringapplication.mapper;

import ir.neshan.myspringapplication.dto.OrderDTO;
import ir.neshan.myspringapplication.entities.Food;
import ir.neshan.myspringapplication.entities.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {
    Order toEntity(OrderDTO orderDto);

    OrderDTO toDto(Food food);
}
