package com.example.Parcial_Java_JPA_Docker.dto;

import java.time.LocalDate;

public class OrderDTO {

    private Long id;
    private LocalDate date;
    private Double total;
    
    // Default constructor
    public OrderDTO() { }
    
    // Parameterized constructor
    public OrderDTO(Long id, LocalDate date, Double total) {
        this.id = id;
        this.date = date;
        this.total = total;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(Object date) {
        this.date = (LocalDate) date;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Object total) {
        this.total = (Double) total;
    }
}
