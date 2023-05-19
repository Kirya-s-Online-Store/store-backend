package com.online.store.service;

import com.online.store.dto.ProductRequest;
import com.online.store.exception.ProductNotFoundException;
import com.online.store.model.Product;
import com.online.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandService brandService;
    private final TypeService typeService;
    private final ModelMapper modelMapper;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with such id not found"));
    }

    @Transactional
    public Product create(ProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        brandService.setBrandToProduct(product, request.getBrandId());
        typeService.setTypeToProduct(product, request.getTypeId());
        return productRepository.save(product);
    }
}
