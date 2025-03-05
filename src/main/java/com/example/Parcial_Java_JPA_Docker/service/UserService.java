package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.UserDTO;
import com.example.Parcial_Java_JPA_Docker.model.User;
import com.example.Parcial_Java_JPA_Docker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // Convert entity to DTO
  public UserDTO convertToDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setName((String) user.getName());
    dto.setEmail((String) user.getEmail());
    return dto;
  }

  // Convert DTO to entity
  public User convertToEntity(UserDTO dto) {
    User user = new User();
    user.setId(dto.getId());
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    return user;
  }

  // Retrieve all users
  public List<UserDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  // Retrieve a user by ID
  public UserDTO getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    return convertToDTO(user);
  }

  // Create a new user
  public UserDTO createUser(UserDTO dto) {
    User user = convertToEntity(dto);
    User savedUser = userRepository.save(user);
    return convertToDTO(savedUser);
  }

  // Update an existing user
  public UserDTO updateUser(Long id, UserDTO dto) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    User updatedUser = userRepository.save(user);
    return convertToDTO(updatedUser);
  }

  // Delete a user
  public void deleteUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    userRepository.delete(user);
  }
}
