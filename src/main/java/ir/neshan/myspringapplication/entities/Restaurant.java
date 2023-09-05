package ir.neshan.myspringapplication.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.UUID;


@Table(name = "restaurants")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;

    @OneToMany
    Set<Food> menu;

    @OneToOne
    User owner;
}
