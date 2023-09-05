package ir.neshan.myspringapplication.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "foods")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;


    @Column(name = "count")
    Integer count;

    @ManyToOne
    Restaurant restaurant;

    @Column(name = "price_per_unit")
    double pricePerUnit;


}
