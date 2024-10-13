package com.example.order_application.services;

import com.example.order_application.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);

    Category updateCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    void deleteCategory(Long id);
}

