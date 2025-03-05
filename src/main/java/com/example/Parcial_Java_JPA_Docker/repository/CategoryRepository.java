package com.example.Parcial_Java_JPA_Docker.repository;

import com.example.Parcial_Java_JPA_Docker.model.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Category entity.
 * Provides CRUD operations and a custom query to find a category by its name.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  /**
   * Finds a category by its name.
   *
   * @param nombre the name of the category to search for.
   * @return an Optional containing the category if found, otherwise empty.
   */
  Optional<Category> findByNombre(String nombre);
}
