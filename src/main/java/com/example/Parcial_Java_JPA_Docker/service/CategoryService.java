package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.CategoryDTO;
import com.example.Parcial_Java_JPA_Docker.model.Category;
import com.example.Parcial_Java_JPA_Docker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Category entities.
 * Provides methods to convert between Category and CategoryDTO,
 * and to perform CRUD operations on categories.
 */
@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  /**
   * Converts a Category entity to a CategoryDTO.
   *
   * @param category the Category entity to convert.
   * @return the corresponding CategoryDTO.
   */
  public CategoryDTO convertToDTO(Category category) {
    CategoryDTO dto = new CategoryDTO();
    dto.setId(category.getId());
    dto.setName(category.getName());
    return dto;
  }

  /**
   * Converts a CategoryDTO to a Category entity.
   *
   * @param dto the CategoryDTO to convert.
   * @return the corresponding Category entity.
   */
  public Category convertToEntity(CategoryDTO dto) {
    Category category = new Category(); // Use default constructor; id is auto-generated
    category.setName(dto.getName());
    return category;
  }

  /**
   * Retrieves all categories and converts them to DTOs.
   *
   * @return a list of CategoryDTOs.
   */
  public List<CategoryDTO> getAllCategories() {
    List<Category> categories = categoryRepository.findAll();
    return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  /**
   * Retrieves a category by its ID and converts it to a DTO.
   *
   * @param id the ID of the category.
   * @return the corresponding CategoryDTO.
   * @throws RuntimeException if the category is not found.
   */
  public CategoryDTO getCategoryById(Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    return convertToDTO(category);
  }

  /**
   * Creates a new category using the provided DTO.
   *
   * @param dto the CategoryDTO containing new category data.
   * @return the created CategoryDTO.
   */
  public CategoryDTO createCategory(CategoryDTO dto) {
    Category category = convertToEntity(dto);
    Category savedCategory = categoryRepository.save(category);
    return convertToDTO(savedCategory);
  }

  /**
   * Updates an existing category with the provided DTO data.
   *
   * @param id  the ID of the category to update.
   * @param dto the CategoryDTO containing updated data.
   * @return the updated CategoryDTO.
   * @throws RuntimeException if the category is not found.
   */
  public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    category.setName(dto.getName());
    Category updatedCategory = categoryRepository.save(category);
    return convertToDTO(updatedCategory);
  }

  /**
   * Deletes a category by its ID.
   *
   * @param id the ID of the category to delete.
   * @throws RuntimeException if the category is not found.
   */
  public void deleteCategory(Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    categoryRepository.delete(category);
  }
}
