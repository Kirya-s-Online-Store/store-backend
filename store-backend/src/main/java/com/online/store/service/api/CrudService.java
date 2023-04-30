package com.online.store.service.api;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    List<T> findAll();

    Optional<T> findById(int id);

    void deleteById(int id);

    T create(T entity);

    T update(T entity);
}