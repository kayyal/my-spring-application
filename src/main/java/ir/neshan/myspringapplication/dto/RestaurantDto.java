package ir.neshan.myspringapplication.dto;


import ir.neshan.myspringapplication.model.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDto {
    Long id;
    String name;

    List<Food> menu;


}
