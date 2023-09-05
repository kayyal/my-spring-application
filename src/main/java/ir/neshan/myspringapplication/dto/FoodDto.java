package ir.neshan.myspringapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    Long id;
    String name;

    Integer count;

    Double pricePerUnit;


}
