package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Category;
import com.example.Parcial_Java_JPA_Docker.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  // Get all categories
  @GetMapping
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  // Get a category by ID
  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    return ResponseEntity.ok(category);
  }

  // Create a new category
  @PostMapping
  public Category createCategory(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  // Update an existing category
  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    category.setName(categoryDetails.getName());
    Category updatedCategory = categoryRepository.save(category);
    return ResponseEntity.ok(updatedCategory);
  }

  // Delete a category
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    categoryRepository.delete(category);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
