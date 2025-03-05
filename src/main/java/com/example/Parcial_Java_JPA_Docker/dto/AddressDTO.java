package com.example.Parcial_Java_JPA_Docker.dto;

/**
 * Data Transfer Object (DTO) for Address.
 * This class is used to transfer address data between processes.
 */
public class AddressDTO {

  // Unique identifier for the address
  private Long id;

  // Street name of the address
  private String street;

  // City of the address
  private String city;

  // Country of the address
  private String country;

  /**
   * Default constructor.
   */
  public AddressDTO() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id      The unique identifier for the address.
   * @param street  The street name.
   * @param city    The city name.
   * @param country The country name.
   */
  public AddressDTO(Long id, String street, String city, String country) {
    this.id = id;
    this.street = street;
    this.city = city;
    this.country = country;
  }

  /**
   * Gets the ID of the address.
   *
   * @return The address ID.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the address.
   *
   * @param id The address ID.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the street of the address.
   *
   * @return The street name.
   */
  public String getStreet() {
    return street;
  }

  /**
   * Sets the street of the address.
   * Note: The parameter is expected to be a String.
   *
   * @param street The street name as an Object.
   */
  public void setStreet(Object street) {
    this.street = (String) street;
  }

  /**
   * Gets the city of the address.
   *
   * @return The city name.
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets the city of the address.
   *
   * @param city The city name.
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Gets the country of the address.
   *
   * @return The country name.
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets the country of the address.
   * Note: The parameter is expected to be a String.
   *
   * @param country The country name as an Object.
   */
  public void setCountry(Object country) {
    this.country = (String) country;
  }
}
