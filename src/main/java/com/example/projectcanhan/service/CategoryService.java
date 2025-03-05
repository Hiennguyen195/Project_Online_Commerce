package com.example.projectcanhan.service;

import com.example.projectcanhan.dto.request.CategoryCreationRequest;
import com.example.projectcanhan.entity.Category;
import com.example.projectcanhan.exception.AppException;
import com.example.projectcanhan.exception.ErrorCode;
import com.example.projectcanhan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryCreationRequest request) {
        Category category = new Category();

        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new AppException(ErrorCode.CATEGORY_EXISTS);
        }

        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());

        return categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(Long.valueOf(categoryId))
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
    }
}
