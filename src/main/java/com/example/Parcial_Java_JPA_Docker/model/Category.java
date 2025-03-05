package com.example.Parcial_Java_JPA_Docker.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity representing a Category.
 * Each Category can have multiple Products associated with it.
 */
@Entity
@Table(name = "categories")
public class Category {

  // Primary key for the Category entity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // One-to-Many relationship with Product.
  // A Category can have a list of Products.
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> product = new ArrayList<>();

  /**
   * Retrieves the name of the category.
   *
   * @return the name of the category.
   * @throws UnsupportedOperationException if the method is not implemented.
   */
  public Object getName() {
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
  }

  /**
   * Sets the name of the category.
   *
   * @param name the new name for the category.
   * @throws UnsupportedOperationException if the method is not implemented.
   */
  public void setName(Object name) {
    throw new UnsupportedOperationException("Unimplemented method 'setName'");
  }

  /**
   * Retrieves the unique identifier of the category.
   *
   * @return the category ID.
   * @throws UnsupportedOperationException if the method is not implemented.
   */
  public Long getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }
}
