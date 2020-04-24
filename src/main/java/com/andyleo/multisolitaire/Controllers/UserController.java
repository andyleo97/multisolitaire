package com.andyleo.multisolitaire.Controllers;

import com.andyleo.multisolitaire.Domain.User;
import com.andyleo.multisolitaire.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Slf4j
@RestController
@RequestMapping("/")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping(value = "/createuser", produces = "application/json", consumes = "application/json")
    public User createUser(@Validated @RequestBody User user){
        user.setDateCreated(Instant.now());
        User user1 = userService.saveUserService(user);
        return user1;
    }

    @CrossOrigin
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public User loginUser(@Validated @RequestBody User user){
        User user1 = userService.getUserService(user);
        return user1;
    }
}
