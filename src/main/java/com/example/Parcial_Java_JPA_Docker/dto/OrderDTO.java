package com.example.Parcial_Java_JPA_Docker.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for Order.
 * This class is used to transfer order data between different layers of the
 * application.
 */
public class OrderDTO {

  // Unique identifier for the order
  private Long id;

  // Date of the order
  private LocalDate date;

  // Total amount of the order
  private Double total;

  /**
   * Default constructor.
   */
  public OrderDTO() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id    The unique identifier for the order.
   * @param date  The date of the order.
   * @param total The total amount of the order.
   */
  public OrderDTO(Long id, LocalDate date, Double total) {
    this.id = id;
    this.date = date;
    this.total = total;
  }

  /**
   * Gets the order ID.
   *
   * @return the order ID.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the order ID.
   *
   * @param id the order ID.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the date of the order.
   *
   * @return the order date.
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Sets the date of the order.
   * Note: The parameter is received as an Object and cast to LocalDate.
   *
   * @param date the order date as an Object.
   */
  public void setDate(Object date) {
    this.date = (LocalDate) date;
  }

  /**
   * Gets the total amount of the order.
   *
   * @return the order total.
   */
  public Double getTotal() {
    return total;
  }

  /**
   * Sets the total amount of the order.
   * Note: The parameter is received as an Object and cast to Double.
   *
   * @param total the total amount of the order as an Object.
   */
  public void setTotal(Object total) {
    this.total = (Double) total;
  }
}
