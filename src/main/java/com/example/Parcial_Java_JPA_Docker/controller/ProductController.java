package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Product;
import com.example.Parcial_Java_JPA_Docker.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  // Get all products
  @GetMapping
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  // Get a product by ID
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    return ResponseEntity.ok(product);
  }

  // Create a new product
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  // Update an existing product
  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Product product = new Product();
    product.setName(productDetails.getName());
    product.setName(productDetails.getName());
    // Optionally update category or other attributes if necessary
    Product updatedProduct = productRepository.save(product);
    return ResponseEntity.ok(updatedProduct);
  }

  // Delete a product
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id) {
    Product product = new Product();
    productRepository.delete(product);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
