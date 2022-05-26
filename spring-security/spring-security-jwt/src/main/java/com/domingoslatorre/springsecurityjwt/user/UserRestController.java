package com.domingoslatorre.springsecurityjwt.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserRestController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRestController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> index() {
        var users = userRepository.findAll().stream()
            .map(this::convertToUserDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserCreateDto userCreateDto) {
        if(userRepository.existsByEmail(userCreateDto.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists with email {}");
        }
        var user = userRepository.save(convertToUser(userCreateDto, passwordEncoder));
        return ResponseEntity.ok(convertToUserDto(user));
    }

    private User convertToUser(UserCreateDto dto, PasswordEncoder passwordEncoder) {
        return new User(dto.email(), dto.name(), passwordEncoder.encode(dto.password()), true);
    }

    private UserDto convertToUserDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getName(), user.getActive());
    }
}
