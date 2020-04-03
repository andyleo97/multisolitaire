package com.andyleo.multisolitaire.Controllers;

import com.andyleo.multisolitaire.Domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @PostMapping("/createuser")
    public User createUser(@Validated @RequestBody User user){
        return user;
    }
}
