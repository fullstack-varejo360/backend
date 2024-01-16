package com.varejo360.backend.repository;

import com.varejo360.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsProductByCode(final Long code);

    boolean existsProductByName(final String name);
}
