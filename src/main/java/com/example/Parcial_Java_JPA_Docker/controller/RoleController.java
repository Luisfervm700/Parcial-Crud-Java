package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.repository.RoleRepository;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

  @Autowired
  private RoleRepository roleRepository;

  // Get all roles
  @GetMapping
  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  // Get a role by ID
  @GetMapping("/{id}")
  public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    return ResponseEntity.ok(role);
  }

  // Create a new role
  @PostMapping
  public Role createRole(@RequestBody Role role) {
    return roleRepository.save(role);
  }

  // Update an existing role
  @PutMapping("/{id}")
  public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
    javax.management.relation.Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    role.setRoleName(roleDetails.getRoleName());
    javax.management.relation.Role updatedRole = roleRepository.save(role);
    return ResponseEntity.ok(updatedRole);
  }

  // Delete a role
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteRole(@PathVariable Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    roleRepository.delete(role);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}