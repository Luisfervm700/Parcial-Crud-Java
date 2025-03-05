package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Address;
import com.example.Parcial_Java_JPA_Docker.repository.AddressRepository;

/**
 * REST Controller for the Address entity.
 * Provides endpoints to retrieve, create, update, and delete addresses.
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

  @Autowired
  private AddressRepository addressRepository;

  /**
   * Retrieve all addresses.
   *
   * @return A list of addresses.
   */
  @GetMapping
  public List<Address> getAllAddresses() {
    return addressRepository.findAll();
  }

  /**
   * Retrieve an address by its ID.
   *
   * @param id The ID of the address to retrieve.
   * @return ResponseEntity containing the found address.
   * @throws RuntimeException if the address is not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    return ResponseEntity.ok(address);
  }

  /**
   * Create a new address.
   *
   * @param address The Address object received in the request body.
   * @return The created address.
   */
  @PostMapping
  public Address createAddress(@RequestBody Address address) {
    return addressRepository.save(address);
  }

  /**
   * Update an existing address.
   *
   * @param id             The ID of the address to update.
   * @param addressDetails The object containing the new address data.
   * @return ResponseEntity with the updated address.
   * @throws RuntimeException if the address is not found.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
    // Find the existing address or throw an exception if not found
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));

    // Update the address fields (check that the correct getters are being used)
    address.setCity(addressDetails.getClass());
    address.setCity(addressDetails.getCountry());
    address.setStreet(addressDetails.getStreet());

    // Save and return the updated address
    Address updatedAddress = addressRepository.save(address);
    return ResponseEntity.ok(updatedAddress);
  }

  /**
   * Delete an address by its ID.
   *
   * @param id The ID of the address to delete.
   * @return ResponseEntity with a map indicating that the deletion was
   *         successful.
   * @throws RuntimeException if the address is not found.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteAddress(@PathVariable Long id) {
    // Find the existing address or throw an exception if not found
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));

    // Delete the found address
    addressRepository.delete(address);

    // Prepare the response indicating successful deletion
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
