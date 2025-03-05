package com.example.Parcial_Java_JPA_Docker.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity representing a Product.
 * This entity is mapped to the "products" table in the database.
 */
@Entity
@Table(name = "products")
public class Product {

  // Primary key for the Product entity.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Many-to-One relationship with Category.
  // A product belongs to one category.
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  // Many-to-Many relationship with Order.
  // A product can be associated with multiple orders.
  @ManyToMany(mappedBy = "products")
  private List<Order> orders = new ArrayList<>();

  /**
   * Retrieves the name of the product.
   *
   * @return the product name.
   * @throws UnsupportedOperationException if the method is not implemented.
   */
  public Object getName() {
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
  }

  /**
   * Sets the name of the product.
   *
   * @param name the new product name.
   * @throws UnsupportedOperationException if the method is not implemented.
   */
  public void setName(Object name) {
    throw new UnsupportedOperationException("Unimplemented method 'setName'");
  }

  /**
   * Retrieves the unique identifier of the product.
   *
   * @return the product ID.
   * @throws UnsupportedOperationException if the method is not implemented.
   */
  public Long getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }
}
