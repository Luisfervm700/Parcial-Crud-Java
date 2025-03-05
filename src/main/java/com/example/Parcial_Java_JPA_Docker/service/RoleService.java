package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.RoleDTO;
import com.example.Parcial_Java_JPA_Docker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// NOTE: Ensure you are importing your custom Role entity.
// The current import below uses the JMX Role class.
import javax.management.relation.Role;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  /**
   * Converts a Role entity to a RoleDTO.
   *
   * @param role the Role entity to convert.
   * @return the corresponding RoleDTO.
   */
  public RoleDTO convertToDTO(Role role) {
    RoleDTO dto = new RoleDTO();
    dto.setName(role.getRoleName()); // Assumes the Role entity has a getRoleName() method
    return dto;
  }

  /**
   * Converts a RoleDTO to a Role entity.
   *
   * @param dto the RoleDTO to convert.
   * @return the corresponding Role entity.
   */
  public Role convertToEntity(RoleDTO dto) {
    // Create a new Role instance. The constructor here takes two parameters (id,
    // name).
    // We pass null for the ID, as it will be auto-generated.
    Role role = new Role(null, null);
    role.setRoleName(dto.getName());
    return role;
  }

  /**
   * Retrieves all roles from the repository and converts them to DTOs.
   *
   * @return a list of RoleDTOs.
   */
  public List<RoleDTO> getAllRoles() {
    List<Role> roles = roleRepository.findAll();
    return roles.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  /**
   * Retrieves a role by its ID and converts it to a DTO.
   *
   * @param id the ID of the role.
   * @return the corresponding RoleDTO.
   * @throws RuntimeException if no role is found with the provided ID.
   */
  public RoleDTO getRoleById(Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    return convertToDTO(role);
  }

  /**
   * Creates a new role from the provided RoleDTO.
   *
   * @param dto the RoleDTO containing the new role data.
   * @return the created RoleDTO.
   */
  public RoleDTO createRole(RoleDTO dto) {
    Role role = convertToEntity(dto);
    Role savedRole = roleRepository.save(role);
    return convertToDTO(savedRole);
  }

  /**
   * Updates an existing role with the data provided in the RoleDTO.
   *
   * @param id  the ID of the role to update.
   * @param dto the RoleDTO containing updated role data.
   * @return the updated RoleDTO.
   * @throws RuntimeException if no role is found with the provided ID.
   */
  public RoleDTO updateRole(Long id, RoleDTO dto) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    role.setRoleName(dto.getName());
    Role updatedRole = roleRepository.save(role);
    return convertToDTO(updatedRole);
  }

  /**
   * Deletes a role by its ID.
   *
   * @param id the ID of the role to delete.
   * @throws RuntimeException if no role is found with the provided ID.
   */
  public void deleteRole(Long id) {
    Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    roleRepository.delete(role);
  }
}
