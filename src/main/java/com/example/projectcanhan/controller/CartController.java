package com.example.projectcanhan.controller;

import com.example.projectcanhan.dto.request.CartItemDTO;
import com.example.projectcanhan.dto.request.CartItemRequest;
import com.example.projectcanhan.entity.Cart;
import com.example.projectcanhan.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItemDTO addToCart(@RequestBody CartItemRequest request) {
        // Logic thêm sản phẩm vào giỏ hàng
    return cartService.addToCart(request.getUserId(), request.getProductId(), request.getQuantity());
    }

//    @GetMapping("/{userId}")
//    public List<CartItemDTO> getCart(@PathVariable String userId) {
//        // Logic lấy thông tin giỏ hàng của user
//        return cartService.getCart(userId);
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItemDTO>> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

}

