package com.example.projectcanhan.dto.request;

import java.math.BigDecimal;

public class ProductUpdateRequest {

    private String productDescription;
    private BigDecimal productPrice;



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


}
