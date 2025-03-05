package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Category;
import com.example.Parcial_Java_JPA_Docker.repository.CategoryRepository;

/**
 * REST Controller for the Category entity.
 * Provides endpoints to manage categories.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  /**
   * Retrieve all categories.
   *
   * @return A list of all categories.
   */
  @GetMapping
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  /**
   * Retrieve a category by its ID.
   *
   * @param id The ID of the category to retrieve.
   * @return ResponseEntity containing the found category.
   * @throws RuntimeException if the category is not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    return ResponseEntity.ok(category);
  }

  /**
   * Create a new category.
   *
   * @param category The Category object provided in the request body.
   * @return The created category.
   */
  @PostMapping
  public Category createCategory(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  /**
   * Update an existing category.
   *
   * @param id              The ID of the category to update.
   * @param categoryDetails The new details for the category.
   * @return ResponseEntity with the updated category.
   * @throws RuntimeException if the category is not found.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
    // Find the category or throw an exception if not found
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

    // Update the category's name
    category.setName(categoryDetails.getName());

    // Save and return the updated category
    Category updatedCategory = categoryRepository.save(category);
    return ResponseEntity.ok(updatedCategory);
  }

  /**
   * Delete a category by its ID.
   *
   * @param id The ID of the category to delete.
   * @return ResponseEntity with a map indicating that the deletion was
   *         successful.
   * @throws RuntimeException if the category is not found.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id) {
    // Find the category or throw an exception if not found
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

    // Delete the found category
    categoryRepository.delete(category);

    // Prepare the response indicating successful deletion
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
