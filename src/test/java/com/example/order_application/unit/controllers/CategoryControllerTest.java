package com.example.order_application.controllers;

import com.example.order_application.entities.Category;
import com.example.order_application.serviceImpl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoryControllerTest {
    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryServiceImpl categoryService;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category();
        category.setId(1L);
        category.setName("Test Category");
    }

    @Test
    void testAddCategory() {
        when(categoryService.addCategory(any(Category.class))).thenReturn(category);

        ResponseEntity<Category> response = categoryController.addCategory(category);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(category.getName(), response.getBody().getName());
        verify(categoryService, times(1)).addCategory(category);
    }

    @Test
    void testUpdateCategory() {
        when(categoryService.updateCategory(any(Category.class))).thenReturn(category);

        ResponseEntity<Category> response = categoryController.updateCategory(1L, category);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(category.getName(), response.getBody().getName());
        verify(categoryService, times(1)).updateCategory(category);
    }

    @Test
    void testUpdateCategory_NotFound() {
        when(categoryService.updateCategory(any(Category.class))).thenReturn(null);

        ResponseEntity<Category> response = categoryController.updateCategory(1L, category);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(categoryService, times(1)).updateCategory(category);
    }

    @Test
    void testGetCategoryById() {
        when(categoryService.getCategoryById(1L)).thenReturn(category);

        ResponseEntity<Category> response = categoryController.getCategoryById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(category.getName(), response.getBody().getName());
        verify(categoryService, times(1)).getCategoryById(1L);
    }

    @Test
    void testGetCategoryById_NotFound() {
        when(categoryService.getCategoryById(1L)).thenReturn(null);

        ResponseEntity<Category> response = categoryController.getCategoryById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(categoryService, times(1)).getCategoryById(1L);
    }

    @Test
    void testGetAllCategories() {
        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(category));

        ResponseEntity<List<Category>> response = categoryController.getAllCategories();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(category.getName(), response.getBody().get(0).getName());
        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    void testDeleteCategory() {
        ResponseEntity<Void> response = categoryController.deleteCategory(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(categoryService, times(1)).deleteCategory(1L);
    }

}