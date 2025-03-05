package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.CategoryDTO;
import com.example.Parcial_Java_JPA_Docker.model.Category;
import com.example.Parcial_Java_JPA_Docker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Convert Category entity to CategoryDTO
    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    // Convert CategoryDTO to Category entity
    public Category convertToEntity(CategoryDTO dto) {
        Category category = new Category();  // Use default constructor; id is auto-generated
        category.setName(dto.getName());
        return category;
    }

    // Retrieve all categories and convert them to DTOs
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Retrieve a category by its ID and convert it to a DTO
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        return convertToDTO(category);
    }

    // Create a new category from a DTO
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = convertToEntity(dto);
        Category savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    // Update an existing category using a DTO
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        category.setName(dto.getName());
        Category updatedCategory = categoryRepository.save(category);
        return convertToDTO(updatedCategory);
    }

    // Delete a category by its ID
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        categoryRepository.delete(category);
    }
}
