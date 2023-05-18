package com.online.store.service;

import com.online.store.model.Brand;
import com.online.store.repository.BrandRepository;
import com.online.store.service.api.CreateReadService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService implements CreateReadService<Brand> {

    private final BrandRepository brandRepository;

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Brand findById(int id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand with such id not found"));
    }

    @Override
    public Brand create(Brand entity) {
        return brandRepository.save(entity);
    }
}
