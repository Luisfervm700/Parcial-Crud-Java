package com.example.Parcial_Java_JPA_Docker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Note: The import below uses javax.management.relation.Role,
// which may conflict with your custom Role entity. Consider importing your own Role class.
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

/**
 * Entity representing a User.
 * This class defines relationships with Address (One-to-One), Role
 * (Many-to-Many),
 * and Order (One-to-Many).
 */
@Entity
@Table(name = "users")
public class User {

  // Unique identifier for the User entity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // One-to-One relationship with Address.
  // A User has one Address, and all operations cascade to the Address.
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

  // Many-to-Many relationship with Role.
  // A User can have multiple Roles and each Role can belong to many Users.
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  // One-to-Many relationship with Order.
  // A User can have multiple Orders.
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Order> orders = new ArrayList<>();

  /**
   * Retrieves the user's name.
   * Note: This method is currently unimplemented.
   *
   * @return the user's name.
   */
  public Object getName() {
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
  }

  /**
   * Sets the user's name.
   * Note: This method is currently unimplemented.
   *
   * @param name2 the name to set for the user.
   */
  public void setName(Object name2) {
    throw new UnsupportedOperationException("Unimplemented method 'setName'");
  }

  /**
   * Retrieves the user's email.
   * Note: This method is currently unimplemented.
   *
   * @return the user's email.
   */
  public Object getEmail() {
    throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
  }

  /**
   * Sets the user's email.
   * Note: This method is currently unimplemented.
   *
   * @param email2 the email to set for the user.
   */
  public void setEmail(Object email2) {
    throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
  }

  /**
   * Retrieves the unique identifier of the user.
   * Note: This method is currently unimplemented.
   *
   * @return the user's ID.
   */
  public Long getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }

  /**
   * Sets the unique identifier of the user.
   * Note: This method is currently unimplemented.
   *
   * @param id2 the user's ID.
   */
  public void setId(Long id2) {
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
  }
}
