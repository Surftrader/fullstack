package ua.com.poseal.jwt.backend.mappers;

import org.mapstruct.Mapper;
import ua.com.poseal.jwt.backend.dto.UserDto;
import ua.com.poseal.jwt.backend.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

}
