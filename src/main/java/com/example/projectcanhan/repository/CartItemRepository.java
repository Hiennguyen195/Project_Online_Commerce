package com.example.projectcanhan.repository;

import com.example.projectcanhan.dto.request.CartItemDTO;
import com.example.projectcanhan.entity.CartItem;
import com.example.projectcanhan.entity.Product;
import com.example.projectcanhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByUserAndProduct(User user, Product product);
    List<CartItem> findByCart_User(User user);

}
