package com.api.maping_jpa.repo;

import com.api.maping_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
