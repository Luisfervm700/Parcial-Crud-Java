package com.example.Parcial_Java_JPA_Docker.repository;

import com.example.Parcial_Java_JPA_Docker.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Buscar productos cuyo nombre contenga la cadena indicada
    List<Product> findByNombreContaining(String name);

    // Buscar productos por el ID de la categoría
    List<Product> findByCategoriaId(Long categoryId);
}
