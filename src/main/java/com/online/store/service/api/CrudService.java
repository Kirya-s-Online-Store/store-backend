package com.online.store.service.api;

import java.util.Optional;

public interface CrudService<T> {

    Optional<T> findById(int id);

    void deleteById(int id);

    T create(T entity);

    T update(int id, T entity);
}