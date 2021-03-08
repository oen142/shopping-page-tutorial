package com.wani.abeepagetutorial.domain.catelog.product.repository;

import com.wani.abeepagetutorial.domain.catelog.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
