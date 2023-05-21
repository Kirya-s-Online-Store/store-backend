package com.online.store.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreateReadService<T> {

    Page<T> findAll(Pageable pageable);

    T findById(int id);

    T create(T entity);
}