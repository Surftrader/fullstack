package ua.com.poseal.jwt.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.poseal.jwt.backend.dtos.SignUpDto;
import ua.com.poseal.jwt.backend.dtos.UserDto;
import ua.com.poseal.jwt.backend.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
