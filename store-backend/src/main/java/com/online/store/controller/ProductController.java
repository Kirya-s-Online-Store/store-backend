package com.online.store.controller;

import com.online.store.exception.ProductNotFoundException;
import com.online.store.model.Product;
import com.online.store.service.ProductService;
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

import java.net.URI;

@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
@RequiredArgsConstructor
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product content = productService.findById(Integer.parseInt(id))
                .orElseThrow(ProductNotFoundException::new);
        return ResponseEntity.ok(content);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product content = productService.create(product);
        return ResponseEntity.ok()
                .location(URI.create("/api/product/" + content.getId()))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,
                                                 @RequestBody Product product) {
        product.setId(Integer.parseInt(id));
        Product updatedProduct = productService.update(product);
        return ResponseEntity.ok(updatedProduct);
    }
}