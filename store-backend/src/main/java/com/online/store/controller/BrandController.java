package com.online.store.controller;

import com.online.store.model.Brand;
import com.online.store.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<Page<Brand>> getAll(Pageable pageable) {
        Page<Brand> brands = brandService.findAll(pageable);
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {
        Brand createdBrand = brandService.create(brand);
        return ResponseEntity.ok(createdBrand);
    }
}
