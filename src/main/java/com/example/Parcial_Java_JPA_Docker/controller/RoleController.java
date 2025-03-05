package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.repository.RoleRepository;

/**
 * REST Controller for managing roles.
 * Provides endpoints to retrieve, create, update, and delete roles.
 */
@RestController
@RequestMapping("/api/roles")
public class RoleController {

  @Autowired
  private RoleRepository roleRepository;

  /**
   * Retrieve all roles.
   *
   * @return A list of roles.
   */
  @GetMapping
  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  /**
   * Retrieve a role by its ID.
   *
   * @param id The ID of the role to retrieve.
   * @return A ResponseEntity containing the found role.
   * @throws RuntimeException if the role is not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    return ResponseEntity.ok(role);
  }

  /**
   * Create a new role.
   *
   * @param role The role object provided in the request body.
   * @return The created role.
   */
  @PostMapping
  public Role createRole(@RequestBody Role role) {
    return roleRepository.save(role);
  }

  /**
   * Update an existing role.
   *
   * @param id          The ID of the role to update.
   * @param roleDetails The new details for the role.
   * @return A ResponseEntity with the updated role.
   * @throws RuntimeException if the role is not found.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
    // Find the role or throw an exception if not found
    javax.management.relation.Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));

    // Update the role's name
    role.setRoleName(roleDetails.getRoleName());

    // Save and return the updated role
    javax.management.relation.Role updatedRole = roleRepository.save(role);
    return ResponseEntity.ok(updatedRole);
  }

  /**
   * Delete a role by its ID.
   *
   * @param id The ID of the role to delete.
   * @return A ResponseEntity with a map indicating that the deletion was
   *         successful.
   * @throws RuntimeException if the role is not found.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteRole(@PathVariable Long id) {
    // Find the role or throw an exception if not found
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));

    // Delete the found role
    roleRepository.delete(role);

    // Prepare and return a response indicating successful deletion
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
