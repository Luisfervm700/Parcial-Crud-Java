package com.example.Parcial_Java_JPA_Docker.repository;

import com.example.Parcial_Java_JPA_Docker.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Product entity.
 * Provides CRUD operations and custom queries for Product objects.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  /**
   * Finds products whose name contains the specified substring.
   *
   * @param name the substring to search within product names.
   * @return a list of products that contain the specified substring in their
   *         name.
   */
  List<Product> findByNombreContaining(String name);

  /**
   * Finds products by the category's ID.
   *
   * @param categoryId the ID of the category.
   * @return a list of products that belong to the specified category.
   */
  List<Product> findByCategoriaId(Long categoryId);
}
