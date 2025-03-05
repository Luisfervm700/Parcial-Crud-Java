package com.example.Parcial_Java_JPA_Docker.dto;

/**
 * Data Transfer Object (DTO) for Category.
 * This class is used to transfer category data between different layers of the
 * application.
 */
public class CategoryDTO {

  // Unique identifier for the category
  private Long id;

  // Name of the category
  private String name;

  /**
   * Default constructor.
   */
  public CategoryDTO() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id   the unique identifier of the category
   * @param name the name of the category
   */
  public CategoryDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Gets the category ID.
   *
   * @return the unique identifier of the category
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the category ID.
   *
   * @param id the unique identifier of the category
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name of the category.
   *
   * @return the category name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the category.
   * 
   * Note: The parameter is received as an Object and cast to a String.
   *
   * @param name the category name as an Object
   */
  public void setName(Object name) {
    this.name = (String) name;
  }
}
