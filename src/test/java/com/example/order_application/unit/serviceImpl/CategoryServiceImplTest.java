package com.example.order_application.unit.serviceImpl;

import com.example.order_application.OrderApplication;
import com.example.order_application.entities.Category;
import com.example.order_application.repositories.CategoryRepository;
import com.example.order_application.serviceImpl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = OrderApplication.class)
@AutoConfigureMockMvc
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

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
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        Category result = categoryService.addCategory(category);

        assertNotNull(result);
        assertEquals(category.getName(), result.getName());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testAddCategory_Null() {
        Category result = categoryService.addCategory(null);

        assertNull(result);
        verify(categoryRepository, never()).save(any());
    }

    @Test
    void testUpdateCategory() {
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        Category result = categoryService.updateCategory(category);

        assertNotNull(result);
        assertEquals(category.getName(), result.getName());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testUpdateCategory_Null() {
        Category result = categoryService.updateCategory(null);

        assertNull(result);
        verify(categoryRepository, never()).save(any());
    }

    @Test
    void testGetCategoryById() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Category result = categoryService.getCategoryById(1L);

        assertNotNull(result);
        assertEquals(category.getName(), result.getName());
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCategoryById_Null() {
        Category result = categoryService.getCategoryById(null);

        assertNull(result);
        verify(categoryRepository, never()).findById(any());
    }

    @Test
    void testGetAllCategories() {
        when(categoryRepository.findAll()).thenReturn(List.of(category));

        List<Category> result = categoryService.getAllCategories();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(category.getName(), result.get(0).getName());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testDeleteCategory() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        categoryService.deleteCategory(1L);

        verify(categoryRepository, times(1)).delete(category);
    }

    @Test
    void testDeleteCategory_Null() {
        categoryService.deleteCategory(null);

        verify(categoryRepository, never()).delete(any());
    }

}