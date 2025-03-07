package com.example.projectcanhan.dto.request;

import com.example.projectcanhan.entity.CartItem;

import java.math.BigDecimal;

public class CartItemDTO {

        private Long productId;
        private String productName;
        private int quantity;
        private BigDecimal price;

        public CartItemDTO(CartItem cartItem) {
            this.productId = cartItem.getProduct().getProductId();
            this.productName = cartItem.getProduct().getProductName();
            this.quantity = cartItem.getQuantity();
            this.price = cartItem.getProduct().getProductPrice();
        }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
