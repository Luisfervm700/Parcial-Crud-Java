package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.AddressDTO;
import com.example.Parcial_Java_JPA_Docker.model.Address;
import com.example.Parcial_Java_JPA_Docker.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Convert Address entity to AddressDTO
    public AddressDTO convertToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCountry(address.getClass());
        dto.setCountry(address.getCountry());
        return dto;
    }

    // Convert AddressDTO to Address entity
    public Address convertToEntity(AddressDTO dto) {
        Address address = new Address(); // Using the default constructor
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCity(dto.getCountry());
        return address;
    }

    // Retrieve all addresses and convert them to DTOs
    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Retrieve an address by its ID and convert it to a DTO
    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        return convertToDTO(address);
    }

    // Create a new address from a DTO
    public AddressDTO createAddress(AddressDTO dto) {
        Address address = convertToEntity(dto);
        Address savedAddress = addressRepository.save(address);
        return convertToDTO(savedAddress);
    }

    // Update an existing address using a DTO
    public AddressDTO updateAddress(Long id, AddressDTO dto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCity(dto.getCountry());
        Address updatedAddress = addressRepository.save(address);
        return convertToDTO(updatedAddress);
    }

    // Delete an address by its ID
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        addressRepository.delete(address);
    }
}
