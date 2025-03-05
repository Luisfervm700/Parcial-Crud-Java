package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.RoleDTO;
import com.example.Parcial_Java_JPA_Docker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  // Convert Role entity to RoleDTO
  public RoleDTO convertToDTO(Role role) {
    RoleDTO dto = new RoleDTO();
    dto.setName(role.getRoleName());
    return dto;
  }

  // Convert RoleDTO to Role entity
  public Role convertToEntity(RoleDTO dto) {
    Role role = new Role(null, null);
    role.setRoleName(dto.getName());
    return role;
  }

  // Retrieve all roles and convert them to DTOs
  public List<RoleDTO> getAllRoles() {
    List<Role> roles = roleRepository.findAll();
    return roles.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  // Retrieve a role by ID and convert it to a DTO
  public RoleDTO getRoleById(Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    return convertToDTO(role);
  }

  // Create a new role from a DTO
  public RoleDTO createRole(RoleDTO dto) {
    Role role = convertToEntity(dto);
    Role savedRole = roleRepository.save(role);
    return convertToDTO(savedRole);
  }

  // Update an existing role using a DTO
  public RoleDTO updateRole(Long id, RoleDTO dto) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    role.setRoleName(dto.getName());
    Role updatedRole = roleRepository.save(role);
    return convertToDTO(updatedRole);
  }

  // Delete a role by its ID
  public void deleteRole(Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    roleRepository.delete(role);
  }
}
