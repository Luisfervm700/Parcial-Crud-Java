package com.example.Parcial_Java_JPA_Docker.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Parcial_Java_JPA_Docker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Método personalizado para buscar por email
    Optional<User> findByEmail(String email);

    // Método personalizado para buscar usuarios cuyo nombre contenga la cadena
    // indicada
    List<User> findByNameContaining(String name);
}
