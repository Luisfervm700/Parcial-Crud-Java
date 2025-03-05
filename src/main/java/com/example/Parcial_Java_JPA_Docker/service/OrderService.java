package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.OrderDTO;
import com.example.Parcial_Java_JPA_Docker.model.Order;
import com.example.Parcial_Java_JPA_Docker.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Order entities.
 * Provides methods to convert between Order and OrderDTO,
 * as well as CRUD operations for orders.
 */
@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  /**
   * Converts an Order entity to an OrderDTO.
   *
   * @param order the Order entity to convert.
   * @return the corresponding OrderDTO.
   */
  public OrderDTO convertToDTO(Order order) {
    OrderDTO dto = new OrderDTO();
    dto.setId(order.getId()); // Copy the ID from the Order entity
    dto.setDate(order.getDate()); // Copy the order date
    dto.setTotal(order.getTotal());// Copy the total amount
    return dto;
  }

  /**
   * Converts an OrderDTO to an Order entity.
   *
   * @param dto the OrderDTO to convert.
   * @return the corresponding Order entity.
   */
  public Order convertToEntity(OrderDTO dto) {
    Order order = new Order(); // Create a new instance of Order (using the default constructor)
    // For new orders, the ID is typically auto-generated, so no need to set it
    order.setDate(dto.getDate()); // Set the order date from the DTO
    order.setTotal(dto.getTotal());// Set the total amount from the DTO
    return order;
  }

  /**
   * Retrieves all orders and converts them to DTOs.
   *
   * @return a list of OrderDTOs.
   */
  public List<OrderDTO> getAllOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  /**
   * Retrieves an order by its ID and converts it to a DTO.
   *
   * @param id the ID of the order.
   * @return the corresponding OrderDTO.
   * @throws RuntimeException if the order is not found.
   */
  public OrderDTO getOrderById(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    return convertToDTO(order);
  }

  /**
   * Creates a new order from the provided DTO.
   *
   * @param dto the OrderDTO containing the order data.
   * @return the created OrderDTO.
   */
  public OrderDTO createOrder(OrderDTO dto) {
    Order order = convertToEntity(dto);
    Order savedOrder = orderRepository.save(order);
    return convertToDTO(savedOrder);
  }

  /**
   * Updates an existing order with the data provided in the DTO.
   *
   * @param id  the ID of the order to update.
   * @param dto the OrderDTO containing updated order data.
   * @return the updated OrderDTO.
   * @throws RuntimeException if the order is not found.
   */
  public OrderDTO updateOrder(Long id, OrderDTO dto) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    order.setDate(dto.getDate());
    order.setTotal(dto.getTotal());
    Order updatedOrder = orderRepository.save(order);
    return convertToDTO(updatedOrder);
  }

  /**
   * Deletes an order by its ID.
   *
   * @param id the ID of the order to delete.
   * @throws RuntimeException if the order is not found.
   */
  public void deleteOrder(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    orderRepository.delete(order);
  }
}
