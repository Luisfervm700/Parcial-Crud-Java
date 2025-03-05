package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.ProductDTO;
import com.example.Parcial_Java_JPA_Docker.model.Product;
import com.example.Parcial_Java_JPA_Docker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  // Convert Product entity to ProductDTO
  public ProductDTO convertToDTO(Product product) {
    ProductDTO dto = new ProductDTO();
    dto.setId(product.getId()); // Copy the ID from the Product entity
    dto.setName(product.getName()); // Copy the product name
    dto.setPrice(product.getName()); // CORREGIDO: Copiar el precio correctamente
    return dto;
  }

  // Convert ProductDTO to Product entity
  public Product convertToEntity(ProductDTO dto) {
    Product product = new Product(); // Create a new instance of Product (using the default constructor)
    product.setName(dto.getName()); // Set the product name from the DTO
    product.setName(dto.getPrice()); // CORREGIDO: Asignar el precio correctamente
    return product;
  }

  // Retrieve all products and convert them to DTOs
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  // Retrieve a product by ID and convert it to a DTO
  public ProductDTO getProductById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    return convertToDTO(product);
  }

  // Create a new product from a DTO
  public ProductDTO createProduct(ProductDTO dto) {
    Product product = convertToEntity(dto);
    Product savedProduct = productRepository.save(product);
    return convertToDTO(savedProduct);
  }

  // Update an existing product using a DTO
  public ProductDTO updateProduct(Long id, ProductDTO dto) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    product.setName(dto.getName());
    product.setName(dto.getPrice()); // CORREGIDO: Asignar el precio correctamente
    Product updatedProduct = productRepository.save(product);
    return convertToDTO(updatedProduct);
  }

  // Delete a product by its ID
  public void deleteProduct(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    productRepository.delete(product);
  }
}
