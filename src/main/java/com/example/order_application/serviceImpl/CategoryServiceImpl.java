package com.example.order_application.serviceImpl;

import com.example.order_application.entities.Category;
import com.example.order_application.repositories.CategoryRepository;
import com.example.order_application.services.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        if (category != null) {
            return this.categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        if (category != null) {
            return (Category) this.categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        if (id != null) {
            return this.categoryRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) this.categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        if (id != null) {
            final Category category = this.categoryRepository.findById(id).get();
            this.categoryRepository.delete(category);
        }
    }
}
