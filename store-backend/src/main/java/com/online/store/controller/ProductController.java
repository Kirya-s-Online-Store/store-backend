package com.online.store.controller;

import com.online.store.dto.ProductCreateDTO;
import com.online.store.model.Product;
import com.online.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        Product content = productService.findById(id);
        return ResponseEntity.ok(content);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateDTO product) {
        Product content = productService.create(product);
        return ResponseEntity.ok()
                .location(URI.create("/api/product/" + content.getId()))
                .build();
    }
}
