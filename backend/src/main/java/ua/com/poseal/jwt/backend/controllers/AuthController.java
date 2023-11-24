package ua.com.poseal.jwt.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.poseal.jwt.backend.dto.CredentialDto;
import ua.com.poseal.jwt.backend.dto.UserDto;
import ua.com.poseal.jwt.backend.services.UserService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialDto credentialDto) {
        UserDto user = userService.login(credentialDto);
        return ResponseEntity.ok(user);
    }
}
