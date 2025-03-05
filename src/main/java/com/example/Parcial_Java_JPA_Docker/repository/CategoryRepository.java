package com.example.Parcial_Java_JPA_Docker.repository;

import com.example.Parcial_Java_JPA_Docker.model.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Buscar una categoría por su nombre
    Optional<Category> findByNombre(String nombre);
}
