package com.example.Parcial_Java_JPA_Docker.dto;

public class RoleDTO {

    private Long id;
    private String name;
    
    // Default constructor
    public RoleDTO() { }
    
    // Parameterized constructor
    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters and Setters
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
}

