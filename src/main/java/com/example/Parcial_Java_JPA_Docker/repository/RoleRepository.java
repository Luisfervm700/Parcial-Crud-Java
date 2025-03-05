package com.example.Parcial_Java_JPA_Docker.repository;

import java.util.Optional;
import javax.management.relation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Método para buscar un rol por su nombre
    Optional<Role> findByNombre(String nombre);
}
