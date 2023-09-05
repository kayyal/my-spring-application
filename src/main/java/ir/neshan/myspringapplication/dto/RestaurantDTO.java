package ir.neshan.myspringapplication.dto;


import ir.neshan.myspringapplication.entities.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDTO {
    UUID id;
    String name;

    List<Food> menu;


}
