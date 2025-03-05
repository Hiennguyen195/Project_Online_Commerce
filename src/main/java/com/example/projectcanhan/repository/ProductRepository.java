package com.example.projectcanhan.repository;

import com.example.projectcanhan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProductName(String productName);


    List<Product> findByCategory_CategoryId(Long categoryId);
}
