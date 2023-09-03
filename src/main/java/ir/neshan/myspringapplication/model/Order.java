package ir.neshan.myspringapplication.model;


import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Order {

    @Id
    private Long id;

    private List<Food> food;

    private int quantity;
}
