package com.example.Parcial_Java_JPA_Docker.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Parcial_Java_JPA_Docker.model.User;

/**
 * Repository interface for the User entity.
 * Provides CRUD operations and custom queries for User objects.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Custom method to find a user by email.
   *
   * @param email the email address of the user.
   * @return an Optional containing the found user, or empty if not found.
   */
  Optional<User> findByEmail(String email);

  /**
   * Custom method to find users whose name contains the specified substring.
   *
   * @param name the substring to search for within user names.
   * @return a list of users whose names contain the specified substring.
   */
  List<User> findByNameContaining(String name);
}
