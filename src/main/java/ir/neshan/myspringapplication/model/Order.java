package ir.neshan.myspringapplication.model;

public class Order {
    private Long id;
    private Food food;
    private int quantity;

    public Order(Long id, Food food, int quantity) {
        this.id = id;
        this.food = food;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
