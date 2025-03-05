package com.example.projectcanhan.service;

import com.example.projectcanhan.dto.request.ProductCreationRequest;
import com.example.projectcanhan.dto.request.ProductDTO;
import com.example.projectcanhan.dto.request.ProductUpdateRequest;
import com.example.projectcanhan.entity.Category;
import com.example.projectcanhan.entity.Product;
import com.example.projectcanhan.exception.AppException;
import com.example.projectcanhan.exception.ErrorCode;
import com.example.projectcanhan.repository.CategoryRepository;
import com.example.projectcanhan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductCreationRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));


        Product product = new Product();

        if (productRepository.existsByProductName(request.getProductName())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTS);
        }

        product.setProductName(request.getProductName());
        product.setProductPrice(request.getProductPrice());
        product.setProductDescription(request.getProductDescription());
        product.setProductStock(request.getProductStock());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
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

    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategory_CategoryId(Long.valueOf(categoryId));
    }


}
