package ir.neshan.myspringapplication.mapper;


import ir.neshan.myspringapplication.dto.UserDTO;
import ir.neshan.myspringapplication.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO userDto);

    UserDTO toDto(User user);
}
