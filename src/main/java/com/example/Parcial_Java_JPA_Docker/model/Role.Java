package com.example.Parcial_Java_JPA_Docker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a Role.
 * A Role can be associated with multiple Users in a Many-to-Many relationship.
 */
@Entity
@Table(name = "roles")
public class Role {
  
    // Primary key for the Role entity.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    // Name of the role (e.g., ADMIN, USER, etc.).
    private String name;
  
    // Many-to-Many relationship with User.
    // This side is mapped by the "roles" attribute in the User entity.
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    
    // Getters and Setters (if required)
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<User> getUsers() {
        return users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
