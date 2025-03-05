package com.example.projectcanhan.dto.request;

import com.example.projectcanhan.entity.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String categoryName;

    public ProductDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getProductName();
        this.description = product.getProductDescription();
        this.price = product.getProductPrice();
        this.stock = product.getProductStock();
        this.categoryName = product.getCategory().getCategoryName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
