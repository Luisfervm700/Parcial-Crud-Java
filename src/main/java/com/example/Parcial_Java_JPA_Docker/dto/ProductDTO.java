package com.example.Parcial_Java_JPA_Docker.dto;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    
    // Default constructor
    public ProductDTO() { }
    
    // Parameterized constructor
    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Object price) {
        this.price = (Double) price;
    }
}
