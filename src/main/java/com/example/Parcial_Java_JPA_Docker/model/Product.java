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

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Many-to-Many relationship with Order
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    public Object getName() {
      throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public void setName(Object name) {
      throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public Long getId() {
      throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}
