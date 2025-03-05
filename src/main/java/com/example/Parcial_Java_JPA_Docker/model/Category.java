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

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-Many relationship with Product
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> product = new ArrayList<>();

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
