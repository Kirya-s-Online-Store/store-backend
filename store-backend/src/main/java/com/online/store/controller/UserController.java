package com.online.store.controller;

import com.online.store.exception.UserNotFoundException;
import com.online.store.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User content = userService.findById(id);
        return ResponseEntity.ok(content);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User content = userService.create(user);
        return ResponseEntity.ok()
                .location(URI.create("/api/product/" + content.getId()))
                .build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok("Entity was deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,
                                           @RequestBody User user) {
        user.setId(Integer.parseInt(id));
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }
}
