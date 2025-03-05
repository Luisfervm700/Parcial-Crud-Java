package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Address;
import com.example.Parcial_Java_JPA_Docker.repository.AddressRepository;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

  @Autowired
  private AddressRepository addressRepository;

  // Get all addresses
  @GetMapping
  public List<Address> getAllAddresses() {
    return addressRepository.findAll();
  }

  // Get an address by ID
  @GetMapping("/{id}")
  public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    return ResponseEntity.ok(address);
  }

  // Create a new address
  @PostMapping
  public Address createAddress(@RequestBody Address address) {
    return addressRepository.save(address);
  }

  // Update an existing address
  @PutMapping("/{id}")
  public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    address.setCity(addressDetails.getClass());
    address.setCity(addressDetails.getCountry());
    address.setStreet(addressDetails.getStreet());
    Address updatedAddress = addressRepository.save(address);
    return ResponseEntity.ok(updatedAddress);
  }

  // Delete an address
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteAddress(@PathVariable Long id) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    addressRepository.delete(address);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
