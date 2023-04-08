package com.online.store.service.api;

import com.online.store.model.User;

import java.util.Optional;

public interface CrudService<T> {

    Optional<T> findById(int id);

    void deleteById(int id);

    T create(T entity);

    T update(int id, T entity);
}