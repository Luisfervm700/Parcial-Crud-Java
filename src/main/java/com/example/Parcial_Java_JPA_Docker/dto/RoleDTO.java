package com.example.Parcial_Java_JPA_Docker.dto;

/**
 * Data Transfer Object (DTO) for Role.
 * This class is used to transfer role data between application layers.
 */
public class RoleDTO {

  // Unique identifier for the role
  private Long id;

  // Name of the role
  private String name;

  /**
   * Default constructor.
   */
  public RoleDTO() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id   The unique identifier for the role.
   * @param name The name of the role.
   */
  public RoleDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Gets the role ID.
   *
   * @return the role's unique identifier.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the role ID.
   *
   * @param id the unique identifier for the role.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the role name.
   *
   * @return the name of the role.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the role name.
   *
   * @param name the name of the role.
   */
  public void setName(String name) {
    this.name = name;
  }
}

