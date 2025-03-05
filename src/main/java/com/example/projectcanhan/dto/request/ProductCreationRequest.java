package com.example.projectcanhan.dto.request;

import com.example.projectcanhan.entity.Category;

import java.math.BigDecimal;

public class ProductCreationRequest {

    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productStock;
    private Long categoryId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategory(Long categoryId) {
        this.categoryId = categoryId;
    }

}
