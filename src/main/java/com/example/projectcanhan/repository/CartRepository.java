package com.example.projectcanhan.repository;

import com.example.projectcanhan.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    boolean existsByCartId(Long cartId);
}
