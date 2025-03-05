package com.example.projectcanhan.controller;

import com.example.projectcanhan.dto.request.ProductCreationRequest;
import com.example.projectcanhan.dto.request.ProductUpdateRequest;
import com.example.projectcanhan.entity.Product;
import com.example.projectcanhan.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    Product createProduct(@RequestBody @Valid ProductCreationRequest request) {
        return productService.createProduct(request);
    }

    @PutMapping("/{productId}")
    Product updateProduct(@PathVariable String productId, @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(productId, request);
    }

    @GetMapping
    Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    Product getProduct(@PathVariable("productId") String productId) {
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{productId}")
    String deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return "Product has been deleted!";
    }
}
