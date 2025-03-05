package com.example.projectcanhan.controller;

import com.example.projectcanhan.dto.request.CategoryCreationRequest;
import com.example.projectcanhan.entity.Category;
import com.example.projectcanhan.repository.CategoryRepository;
import com.example.projectcanhan.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    Category createCategory(@RequestBody CategoryCreationRequest request) {
        return categoryService.createCategory(request);
    }

    @GetMapping
    Iterable<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryId}")
    Category getCategory(@PathVariable("categoryId") String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
}
