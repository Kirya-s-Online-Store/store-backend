package com.online.store.controller;

import com.online.store.model.User;
import com.online.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@RequiredArgsConstructor
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User content = userService.findById(Integer.parseInt(id))
                .orElse(null);
        return ResponseEntity.ok(content);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User content = userService.create(user);
        return ResponseEntity.ok()
                .body(content);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok("Entity was deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,
                                           @RequestBody User user) {
        User updatedUser = userService.update(Integer.parseInt(id), user);
        return ResponseEntity.ok(updatedUser);
    }
}
