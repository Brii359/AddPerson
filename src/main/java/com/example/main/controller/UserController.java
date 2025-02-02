package com.example.main.controller;
import com.example.main.exception.UserNotFoundException;
import com.example.main.model.Users;
import com.example.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    Users newUser(@RequestBody Users newUsers) {
        return userRepository.save(newUsers);
    }

    @GetMapping("/usersall")
    List<Users> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    Users getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping
    Users updateUser(@RequestBody Users newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(users -> {
                    users.setUsername(newUser.getUsername());
                    users.setName(newUser.getUsername());
                    users.setEmail(newUser.getEmail());
                    return userRepository.save(users);
                        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUserById(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with Id"   +  id  + "Succesful Deleted";
    }






}
