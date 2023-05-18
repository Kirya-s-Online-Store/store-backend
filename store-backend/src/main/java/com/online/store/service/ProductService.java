package com.online.store.service;

import com.online.store.dto.ProductCreateDTO;
import com.online.store.exception.ProductNotFoundException;
import com.online.store.model.Product;
import com.online.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final TypeService typeService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with such id not found"));
    }

    public Product create(ProductCreateDTO request) {
        Product product = modelMapper.map(request, Product.class);
        product.setBrand(brandService.findById(request.getBrandId()));
        product.setType(typeService.findById(request.getTypeId()));
        return productRepository.save(product);
    }
}
