package com.example.Parcial_Java_JPA_Docker.dto;

/**
 * Data Transfer Object (DTO) for Product.
 * This class is used to transfer product data between application layers.
 */
public class ProductDTO {

  // Unique identifier for the product
  private Long id;

  // Name of the product
  private String name;

  // Price of the product
  private Double price;

  /**
   * Default constructor.
   */
  public ProductDTO() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id    The unique identifier of the product.
   * @param name  The name of the product.
   * @param price The price of the product.
   */
  public ProductDTO(Long id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  /**
   * Gets the product ID.
   *
   * @return the product's unique identifier.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the product ID.
   *
   * @param id the unique identifier of the product.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name of the product.
   *
   * @return the product name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the product.
   * Note: The parameter is received as an Object and cast to String.
   *
   * @param name the product name as an Object.
   */
  public void setName(Object name) {
    this.name = (String) name;
  }

  /**
   * Gets the price of the product.
   *
   * @return the product price.
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Sets the price of the product.
   * Note: The parameter is received as an Object and cast to Double.
   *
   * @param price the product price as an Object.
   */
  public void setPrice(Object price) {
    this.price = (Double) price;
  }
}
