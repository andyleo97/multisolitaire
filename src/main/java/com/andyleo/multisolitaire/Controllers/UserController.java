package com.andyleo.multisolitaire.Controllers;

import com.andyleo.multisolitaire.Domain.User;
import com.andyleo.multisolitaire.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createuser", produces = "application/json", consumes = "application/json")
    public User createUser(@Validated @RequestBody User user){
        User user1 = userService.saveUserService(user);
        return user1;
    }
}
