package com.online.store.repository;

import com.online.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
        , PagingAndSortingRepository<Product, Integer> {

    @Query("""
            SELECT p FROM Product p
            LEFT JOIN p.info
            LEFT JOIN p.type
            LEFT JOIN p.brand
            WHERE (:brand_id IS NULL OR p.brand.id = :brand_id)
            AND (:type_id IS NULL OR p.type.id = :type_id)
            """)
    Page<Product> findAllByBrandIdOrTypeId(@Param("brand_id") Integer brandId,
                                           @Param("type_id") Integer typeId,
                                           Pageable pageable);
}

