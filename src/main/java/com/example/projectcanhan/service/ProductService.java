package com.example.projectcanhan.service;

import com.example.projectcanhan.dto.request.ProductCreationRequest;
import com.example.projectcanhan.dto.request.ProductUpdateRequest;
import com.example.projectcanhan.entity.Product;
import com.example.projectcanhan.exception.AppException;
import com.example.projectcanhan.exception.ErrorCode;
import com.example.projectcanhan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductCreationRequest request) {
        Product product = new Product();

        if (productRepository.existsByProductName(request.getProductName())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTS);
        }

        product.setProductName(request.getProductName());
        product.setProductPrice(request.getProductPrice());
        product.setProductDescription(request.getProductDescription());
        product.setProductStock(request.getProductStock());

        return productRepository.save(product);
    }

    public Product updateProduct(String productId, ProductUpdateRequest request) {
        Product product = getProductById(productId);

        product.setProductPrice(request.getProductPrice());
        product.setProductDescription(request.getProductDescription());
        product.setProductStock(request.getProductStock());
        return productRepository.save(product);
    }

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String productId) {
        return productRepository.findById(Long.valueOf(productId))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    public void deleteProduct(String productId){
        productRepository.deleteById(Long.valueOf(productId));
    }


}
