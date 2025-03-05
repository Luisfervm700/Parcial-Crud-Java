package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.AddressDTO;
import com.example.Parcial_Java_JPA_Docker.model.Address;
import com.example.Parcial_Java_JPA_Docker.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Address entities.
 * Provides methods to convert between Address and AddressDTO and to perform
 * CRUD operations.
 */
@Service
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  /**
   * Converts an Address entity to an AddressDTO.
   *
   * @param address the Address entity to convert.
   * @return the corresponding AddressDTO.
   */
  public AddressDTO convertToDTO(Address address) {
    AddressDTO dto = new AddressDTO();
    dto.setId(address.getId());
    dto.setStreet(address.getStreet());
    // NOTE: The following line seems incorrect, as it sets the country using
    // getClass().
    // It is immediately overridden by the next line.
    dto.setCountry(address.getClass());
    // Set the country from the address entity (ensure the getCountry() method is
    // correctly implemented)
    dto.setCountry(address.getCountry());
    return dto;
  }

  /**
   * Converts an AddressDTO to an Address entity.
   *
   * @param dto the AddressDTO to convert.
   * @return the corresponding Address entity.
   */
  public Address convertToEntity(AddressDTO dto) {
    Address address = new Address(); // Using the default constructor
    address.setStreet(dto.getStreet());
    // NOTE: There are duplicate calls to setCity.
    // The following lines may need to be corrected based on the intended mapping.
    address.setCity(dto.getCity());
    address.setCity(dto.getCountry());
    return address;
  }

  /**
   * Retrieves all addresses from the repository and converts them to DTOs.
   *
   * @return a list of AddressDTO objects.
   */
  public List<AddressDTO> getAllAddresses() {
    List<Address> addresses = addressRepository.findAll();
    return addresses.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  /**
   * Retrieves an address by its ID and converts it to a DTO.
   *
   * @param id the ID of the address.
   * @return the AddressDTO for the found address.
   * @throws RuntimeException if no address is found.
   */
  public AddressDTO getAddressById(Long id) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    return convertToDTO(address);
  }

  /**
   * Creates a new address using the provided DTO.
   *
   * @param dto the AddressDTO containing the new address data.
   * @return the created AddressDTO.
   */
  public AddressDTO createAddress(AddressDTO dto) {
    Address address = convertToEntity(dto);
    Address savedAddress = addressRepository.save(address);
    return convertToDTO(savedAddress);
  }

  /**
   * Updates an existing address with the data provided in the DTO.
   *
   * @param id  the ID of the address to update.
   * @param dto the AddressDTO containing updated data.
   * @return the updated AddressDTO.
   * @throws RuntimeException if no address is found with the given ID.
   */
  public AddressDTO updateAddress(Long id, AddressDTO dto) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    address.setStreet(dto.getStreet());
    // NOTE: Duplicate setCity calls. Review these for correct mapping.
    address.setCity(dto.getCity());
    address.setCity(dto.getCountry());
    Address updatedAddress = addressRepository.save(address);
    return convertToDTO(updatedAddress);
  }

  /**
   * Deletes an address by its ID.
   *
   * @param id the ID of the address to delete.
   * @throws RuntimeException if no address is found with the given ID.
   */
  public void deleteAddress(Long id) {
    Address address = addressRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    addressRepository.delete(address);
  }
}
