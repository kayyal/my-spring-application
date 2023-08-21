package ir.neshan.myspringapplication.controller;

import ir.neshan.myspringapplication.model.Food;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodController {

    private final List<Food> foodList = new ArrayList<>();
    /* = List.of(
            new Food(234, "Omlet", 234234.3),
            new Food(456, "pizza", 567)
    );*/


    private long nextId = 1;

    @GetMapping
    public List<Food> getFoodList() {
        return foodList;
    }
}
