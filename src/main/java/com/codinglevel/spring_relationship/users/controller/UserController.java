package com.codinglevel.spring_relationship.users.controller;

import com.codinglevel.spring_relationship.users.dto.UserRequest;
import com.codinglevel.spring_relationship.users.entities.User;
import com.codinglevel.spring_relationship.users.exceptions.UserNotFoundException;
import com.codinglevel.spring_relationship.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody
                                                @Valid UserRequest userRequest) throws UserNotFoundException {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> fetchUsers() {
        return ResponseEntity.ok(userService.fetchUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> userById(@PathVariable("userId")
                                             Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.fetchUser(userId));
    }

    @DeleteMapping("/delete/{userId}")
    public void removeUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }
}
