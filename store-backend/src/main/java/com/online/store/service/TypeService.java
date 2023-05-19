package com.online.store.service;

import com.online.store.model.Brand;
import com.online.store.model.Product;
import com.online.store.model.Type;
import com.online.store.repository.TypeRepository;
import com.online.store.service.api.CreateReadService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TypeService implements CreateReadService<Type> {

    private final TypeRepository typeRepository;

    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type findById(int id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Type with such id not found"));
    }

    @Override
    @Transactional
    public Type create(Type entity) {
        return typeRepository.save(entity);
    }

    public void setTypeToProduct(Product product, int typeId) {
        Type type = typeRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("Type with id=" + typeId + " not found"));
        product.setType(type);
    }
}
