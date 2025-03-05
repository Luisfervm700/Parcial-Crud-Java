package com.example.Parcial_Java_JPA_Docker.repository;

import java.util.Optional;
import javax.management.relation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Role entity.
 * Provides CRUD operations and a custom query to find a role by its name.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  /**
   * Finds a role by its name.
   *
   * @param nombre the name of the role to search for.
   * @return an Optional containing the role if found, otherwise empty.
   */
  Optional<Role> findByNombre(String nombre);
}
