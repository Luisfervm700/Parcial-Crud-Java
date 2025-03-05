package com.example.Parcial_Java_JPA_Docker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing an Address.
 * Mapped to the "addresses" table in the database.
 */
@Entity
@Table(name = "addresses")
public class Address {

  // Primary key for the Address entity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Sets the city for the address.
   * Note: This method is currently unimplemented.
   *
   * @param class1 An object representing the city.
   */
  public void setCity(Object class1) {
    throw new UnsupportedOperationException("Unimplemented method 'setCity'");
  }

  /**
   * Retrieves the country for the address.
   * Note: This method is currently unimplemented.
   *
   * @return An object representing the country.
   */
  public Object getCountry() {
    throw new UnsupportedOperationException("Unimplemented method 'getCountry'");
  }

  /**
   * Retrieves the street for the address.
   * Note: This method is currently unimplemented.
   *
   * @return An object representing the street.
   */
  public Object getStreet() {
    throw new UnsupportedOperationException("Unimplemented method 'getStreet'");
  }

  /**
   * Sets the street for the address.
   * Note: This method is currently unimplemented.
   *
   * @param street An object representing the street.
   */
  public void setStreet(Object street) {
    throw new UnsupportedOperationException("Unimplemented method 'setStreet'");
  }

  /**
   * Retrieves the unique identifier of the address.
   * Note: This method is currently unimplemented.
   *
   * @return the address ID.
   */
  public Long getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }
}
