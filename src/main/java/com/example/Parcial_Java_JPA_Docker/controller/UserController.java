package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Parcial_Java_JPA_Docker.model.User;
import com.example.Parcial_Java_JPA_Docker.repository.UserRepository;

/**
 * REST Controller for managing User entities.
 * Provides endpoints for retrieving, creating, updating, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  /**
   * Retrieve all users.
   *
   * @return A list of all users.
   */
  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Retrieve a user by its ID.
   *
   * @param id The ID of the user to retrieve.
   * @return ResponseEntity containing the found user.
   * @throws RuntimeException if the user is not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    return ResponseEntity.ok(user);
  }

  /**
   * Create a new user.
   *
   * @param user The User object provided in the request body.
   * @return The created user.
   */
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  /**
   * Update an existing user.
   *
   * @param id          The ID of the user to update.
   * @param userDetails The new details for the user.
   * @return ResponseEntity containing the updated user.
   * @throws RuntimeException if the user is not found.
   */
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    // Find the existing user or throw an exception if not found
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));

    // Update the user's attributes
    user.setName(userDetails.getName());
    user.setEmail(userDetails.getEmail());
    // Update other attributes as needed

    // Save and return the updated user
    User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete a user by its ID.
   *
   * @param id The ID of the user to delete.
   * @return ResponseEntity with a map indicating that the deletion was
   *         successful.
   * @throws RuntimeException if the user is not found.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
    // Find the existing user or throw an exception if not found
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));

    // Delete the found user
    userRepository.delete(user);

    // Prepare and return a response indicating successful deletion
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
