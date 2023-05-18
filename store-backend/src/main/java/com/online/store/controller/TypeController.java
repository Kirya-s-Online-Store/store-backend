package com.online.store.controller;


import com.online.store.model.Type;
import com.online.store.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/types")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<Page<Type>> getAll(Pageable pageable) {
        Page<Type> types = typeService.findAll(pageable);
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getType(@PathVariable Integer id) {
        Type type = typeService.findById(id);
        return ResponseEntity.ok(type);
    }

    @PostMapping
    public ResponseEntity<Type> create(@RequestBody Type type) {
        Type createdType = typeService.create(type);
        return ResponseEntity.ok(createdType);
    }
}
