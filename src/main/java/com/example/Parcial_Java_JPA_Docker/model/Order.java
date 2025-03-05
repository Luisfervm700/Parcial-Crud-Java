package com.example.Parcial_Java_JPA_Docker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Date of the order
  private LocalDate date;

  // Total price of the order
  private Double total;

  // Many-to-One relationship with User
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  // Many-to-Many relationship with Product
  @ManyToMany
  @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products = new ArrayList<>();

  // Default Constructor
  public Order() {
  }

  // Parameterized Constructor
  public Order(LocalDate date, Double total, User user, List<Product> products) {
    this.date = date;
    this.total = total;
    this.user = user;
    this.products = products;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
