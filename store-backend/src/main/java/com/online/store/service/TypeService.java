package com.online.store.service;

import com.online.store.model.Type;
import com.online.store.repository.TypeRepository;
import com.online.store.service.api.CreateReadService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
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
    public Type create(Type entity) {
        return typeRepository.save(entity);
    }
}
