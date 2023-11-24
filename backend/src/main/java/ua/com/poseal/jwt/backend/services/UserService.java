package ua.com.poseal.jwt.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.poseal.jwt.backend.dtos.CredentialDto;
import ua.com.poseal.jwt.backend.dtos.SignUpDto;
import ua.com.poseal.jwt.backend.dtos.UserDto;
import ua.com.poseal.jwt.backend.entities.User;
import ua.com.poseal.jwt.backend.exceptions.AppException;
import ua.com.poseal.jwt.backend.mappers.UserMapper;
import ua.com.poseal.jwt.backend.repositories.UserRepository;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialDto credentialDto) {
        User user = userRepository.findByLogin(credentialDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto) {
        Optional<User> oUser = userRepository.findByLogin(signUpDto.login());
        if (oUser.isPresent()) {
            throw new AppException("Login already exist", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(signUpDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }
}
