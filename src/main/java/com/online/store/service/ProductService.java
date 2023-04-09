package com.online.store.service;

import com.online.store.model.Product;
import com.online.store.repository.ProductRepository;
import com.online.store.service.api.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements CrudService<Product> {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product create(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product update(int id, Product entity) {
        entity.setId(id);
        return productRepository.save(entity);
    }
}
