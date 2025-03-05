package com.example.Parcial_Java_JPA_Docker.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Many-to-Many relationship with Product
    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product = new ArrayList<>();

    public Object getDate() {
      throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    public void setDate(Object date) {
      throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }

    public Object getTotal() {
      throw new UnsupportedOperationException("Unimplemented method 'getTotal'");
    }

    public void setTotal(Object total) {
      throw new UnsupportedOperationException("Unimplemented method 'setTotal'");
    }

    public Long getId() {
      throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}
