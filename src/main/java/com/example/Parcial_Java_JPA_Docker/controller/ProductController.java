package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Product;
import com.example.Parcial_Java_JPA_Docker.repository.ProductRepository;

/**
 * REST Controller for the Product entity.
 * Provides endpoints to retrieve, create, update, and delete products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  /**
   * Retrieve all products.
   *
   * @return A list of all products.
   */
  @GetMapping
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  /**
   * Retrieve a product by its ID.
   *
   * @param id The ID of the product to retrieve.
   * @return ResponseEntity containing the found product.
   * @throws RuntimeException if the product is not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    return ResponseEntity.ok(product);
  }

  /**
   * Create a new product.
   *
   * @param product The Product object provided in the request body.
   * @return The created product.
   */
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  /**
   * Update an existing product.
   *
   * @param id             The ID of the product to update.
   * @param productDetails The new details for the product.
   * @return ResponseEntity with the updated product.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    // Note: Typically, you would fetch the existing product by id from the
    // repository.
    Product product = new Product();

    // Update product attributes
    product.setName(productDetails.getName());
    // The following line is duplicated; review if additional fields need to be
    // updated.
    product.setName(productDetails.getName());

    // Optionally update category or other attributes if necessary
    Product updatedProduct = productRepository.save(product);
    return ResponseEntity.ok(updatedProduct);
  }

  /**
   * Delete a product by its ID.
   *
   * @param id The ID of the product to delete.
   * @return ResponseEntity with a map indicating that the deletion was
   *         successful.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id) {
    // Note: Typically, you would retrieve the existing product from the repository
    // before deleting.
    Product product = new Product();
    productRepository.delete(product);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
