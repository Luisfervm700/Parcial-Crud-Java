package com.example.Parcial_Java_JPA_Docker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // One-to-One relationship with Address
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

  // Many-to-Many relationship with Role
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  // One-to-Many relationship with Order
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Order> orders = new ArrayList<>();

  public Object getName() {
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
  }

  public void setName(Object name2) {
    throw new UnsupportedOperationException("Unimplemented method 'setName'");
  }

  public Object getEmail() {
    throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
  }

  public void setEmail(Object email2) {
    throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
  }

  public Long getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }

  public void setId(Long id2) {
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
  }
}
