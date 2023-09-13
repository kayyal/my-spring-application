package ir.neshan.myspringapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    UUID id;
    String username;
    String password;
    String role;
}
