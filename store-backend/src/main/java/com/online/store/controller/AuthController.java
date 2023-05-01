package com.online.store.controller;

import com.online.store.dto.LoginUserDTO;
import com.online.store.dto.RegisterUserDTO;
import com.online.store.service.AuthService;
import com.online.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(LoginUserDTO request) {
        authService.login(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(RegisterUserDTO request) {
        authService.register(request);
        return ResponseEntity.ok().build();
    }
}
