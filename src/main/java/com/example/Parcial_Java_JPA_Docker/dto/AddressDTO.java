package com.example.Parcial_Java_JPA_Docker.dto;

public class AddressDTO {
    
    private Long id;
    private String street;
    private String city;
    private String country;
    
    // Default constructor
    public AddressDTO() { }
    
    // Parameterized constructor
    public AddressDTO(Long id, String street, String city, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(Object street) {
        this.street = (String) street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(Object country) {
        this.country = (String) country;
    }
}
