package ir.neshan.myspringapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    private final List<Food> foodList = List.of(
            new Food(234, "Omlet", 234234.3),
            new Food(234, "pizza", 234)
    );


    private long nextId = 1;

    @GetMapping
    public List<Food> getFoodList() {
        return foodList;
    }
}
