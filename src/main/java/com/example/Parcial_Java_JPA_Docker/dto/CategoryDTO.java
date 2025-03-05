package com.example.Parcial_Java_JPA_Docker.dto;

public class CategoryDTO {
    
    private Long id;
    private String name;
    
    // Default constructor
    public CategoryDTO() { }
    
    // Parameterized constructor
    public CategoryDTO(Long id, String name) {
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
    
    public void setName(Object name) {
        this.name = (String) name;
    }
}
