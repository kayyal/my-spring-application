package ir.neshan.myspringapplication.mapper;


import ir.neshan.myspringapplication.dto.UserDto;
import ir.neshan.myspringapplication.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
