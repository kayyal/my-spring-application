package ir.neshan.myspringapplication.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Table(name = "foods")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    UUID id;

    @Column(name = "name")
    String name;


    @Column(name = "count")
    Integer count;

    @ManyToOne
    Restaurant restaurant;

    @Column(name = "price_per_unit")
    double pricePerUnit;


}
