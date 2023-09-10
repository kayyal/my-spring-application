package ir.neshan.myspringapplication.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;


@Builder
@Table(name = "restaurants")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID")
    UUID id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Food> menu;

    @OneToOne
    User owner;
}
