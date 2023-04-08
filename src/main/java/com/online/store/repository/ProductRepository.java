package com.online.store.repository;

import com.online.store.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>
        , PagingAndSortingRepository<Product, Integer> {

}
