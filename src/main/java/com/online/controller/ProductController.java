package com.online.controller;

import com.google.gson.Gson;
import com.online.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> get() {
        Product product = Product.builder()
                .id(1)
                .name("Something")
                .price(1913.12)
                .build();
        return ResponseEntity
                .ok()
                .body(new Gson().toJson(product));
    }
}
