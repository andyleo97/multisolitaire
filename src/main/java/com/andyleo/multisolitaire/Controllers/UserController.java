package com.andyleo.multisolitaire.Controllers;

import com.andyleo.multisolitaire.Domain.User;
import com.andyleo.multisolitaire.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public ResponseEntity<Object> createUser(@Validated @RequestBody User user){
        user.setDateCreated(Instant.now());
        User user1 = userService.saveUserService(user);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @CrossOrigin
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public User loginUser(@Validated @RequestBody User user) throws Exception {
        User user1 = userService.getUserService(user);
        return user1;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityError(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("");
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleBadLoginAttempt(SQLException e){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
