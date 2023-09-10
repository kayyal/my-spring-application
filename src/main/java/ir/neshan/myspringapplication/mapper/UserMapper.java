package ir.neshan.myspringapplication.mapper;


import ir.neshan.myspringapplication.dto.UserDTO;
import ir.neshan.myspringapplication.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserDTO userDto);

    UserDTO toDto(User user);
}
