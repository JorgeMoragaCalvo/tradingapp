package com.tradingproject.controller;

import com.tradingproject.entities.UserEntity;
import com.tradingproject.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) throws Exception {
        UserEntity isEmailExist = userRepository.findByEmail(user.getEmail());
        if(isEmailExist != null) throw new Exception("Email is already used with another account");

        UserEntity newUser = new UserEntity();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        UserEntity savedUser = userRepository.save(newUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
