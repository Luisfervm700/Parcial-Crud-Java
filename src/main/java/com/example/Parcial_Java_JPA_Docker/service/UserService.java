package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.UserDTO;
import com.example.Parcial_Java_JPA_Docker.model.User;
import com.example.Parcial_Java_JPA_Docker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing User entities.
 * Provides methods to convert between User and UserDTO and perform CRUD
 * operations.
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  /**
   * Converts a User entity to a UserDTO.
   *
   * @param user the User entity to convert.
   * @return the corresponding UserDTO.
   */
  public UserDTO convertToDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setName((String) user.getName());
    dto.setEmail((String) user.getEmail());
    return dto;
  }

  /**
   * Converts a UserDTO to a User entity.
   *
   * @param dto the UserDTO to convert.
   * @return the corresponding User entity.
   */
  public User convertToEntity(UserDTO dto) {
    User user = new User();
    user.setId(dto.getId());
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    return user;
  }

  /**
   * Retrieves all users from the repository and converts them to DTOs.
   *
   * @return a list of UserDTOs.
   */
  public List<UserDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  /**
   * Retrieves a user by its ID and converts it to a DTO.
   *
   * @param id the ID of the user.
   * @return the corresponding UserDTO.
   * @throws RuntimeException if no user is found with the given ID.
   */
  public UserDTO getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    return convertToDTO(user);
  }

  /**
   * Creates a new user from the provided UserDTO.
   *
   * @param dto the UserDTO containing new user data.
   * @return the created UserDTO.
   */
  public UserDTO createUser(UserDTO dto) {
    User user = convertToEntity(dto);
    User savedUser = userRepository.save(user);
    return convertToDTO(savedUser);
  }

  /**
   * Updates an existing user with the data from the provided UserDTO.
   *
   * @param id  the ID of the user to update.
   * @param dto the UserDTO containing updated user data.
   * @return the updated UserDTO.
   * @throws RuntimeException if no user is found with the given ID.
   */
  public UserDTO updateUser(Long id, UserDTO dto) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    User updatedUser = userRepository.save(user);
    return convertToDTO(updatedUser);
  }

  /**
   * Deletes a user by its ID.
   *
   * @param id the ID of the user to delete.
   * @throws RuntimeException if no user is found with the given ID.
   */
  public void deleteUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    userRepository.delete(user);
  }
}
