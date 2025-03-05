package com.example.Parcial_Java_JPA_Docker.dto;

/**
 * Data Transfer Object (DTO) for User.
 * This class is used to transfer user data between application layers.
 */
public class UserDTO {

  // Unique identifier for the user
  private Long id;

  // Name of the user
  private String name;

  // Email of the user
  private String email;

  /**
   * Default constructor.
   */
  public UserDTO() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id    The unique identifier for the user.
   * @param name  The name of the user.
   * @param email The email of the user.
   */
  public UserDTO(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  /**
   * Gets the user ID.
   *
   * @return the unique identifier of the user.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the user ID.
   *
   * @param id the unique identifier for the user.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the user's name.
   *
   * @return the name of the user.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the user's name.
   *
   * @param name the name of the user.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the user's email.
   *
   * @return the email address of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the user's email.
   *
   * @param email the email address of the user.
   */
  public void setEmail(String email) {
    this.email = email;
  }
}

