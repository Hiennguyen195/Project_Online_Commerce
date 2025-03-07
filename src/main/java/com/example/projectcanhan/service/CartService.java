package com.example.projectcanhan.service;

import com.example.projectcanhan.dto.request.CartItemDTO;
import com.example.projectcanhan.entity.Cart;
import com.example.projectcanhan.entity.CartItem;
import com.example.projectcanhan.entity.Product;
import com.example.projectcanhan.entity.User;
import com.example.projectcanhan.repository.CartItemRepository;
import com.example.projectcanhan.repository.CartRepository;
import com.example.projectcanhan.repository.ProductRepository;
import com.example.projectcanhan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public CartItemDTO addToCart(String userId, Long productId, int quantity) {
        Cart cart = getOrCreateCart(userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product)
                .orElse(new CartItem(user, product, 0));

        cartItem.setCart(cart);
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItemRepository.save(cartItem);

        return new CartItemDTO(cartItem);

    }

    public Cart getOrCreateCart(String userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(userRepository.findById(userId)
                            .orElseThrow(() -> new RuntimeException("User not found")));
                    return cartRepository.save(newCart);
                });
    }

//    public List<CartItemDTO> getCart(String userId) {
//        return cartItemRepository.findCartItemsByUserId(userId);
//    }

    public List<CartItemDTO> getCart(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartItemRepository.findByCart_User(user).stream()
                .map(CartItemDTO::new) // Convert Entity -> DTO
                .collect(Collectors.toList());
    }
}

