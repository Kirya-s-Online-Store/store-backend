package com.online.store.service;

import com.online.store.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void findById() {
    }

    @Test
    void deleteById() {

    }

    @Test
    void create() {
//        User user = User.builder()
//                .username("Name")
//                .email("email@email.com")
//                .build();
//
//        System.out.println(userService.create(user));
    }

    @Test
    void update() {
    }
}