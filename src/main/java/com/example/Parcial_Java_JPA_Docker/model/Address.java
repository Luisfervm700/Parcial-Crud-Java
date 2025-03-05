package com.example.Parcial_Java_JPA_Docker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setCity(Object class1) {
      throw new UnsupportedOperationException("Unimplemented method 'setCity'");
    }

    public Object getCountry() {
      throw new UnsupportedOperationException("Unimplemented method 'getCountry'");
    }

    public Object getStreet() {
      throw new UnsupportedOperationException("Unimplemented method 'getStreet'");
    }

    public void setStreet(Object street) {
      throw new UnsupportedOperationException("Unimplemented method 'setStreet'");
    }

    public Long getId() {
      throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}
