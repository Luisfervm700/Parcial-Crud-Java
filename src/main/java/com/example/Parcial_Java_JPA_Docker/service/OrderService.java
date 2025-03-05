package com.example.Parcial_Java_JPA_Docker.service;

import com.example.Parcial_Java_JPA_Docker.dto.OrderDTO;
import com.example.Parcial_Java_JPA_Docker.model.Order;
import com.example.Parcial_Java_JPA_Docker.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  // Convert Order entity to OrderDTO
  public OrderDTO convertToDTO(Order order) {
    OrderDTO dto = new OrderDTO();
    dto.setId(order.getId()); // Copy the ID from the Order entity
    dto.setDate(order.getDate()); // Copy the order date
    dto.setTotal(order.getTotal()); // Copy the total amount
    return dto;
  }

  // Convert OrderDTO to Order entity
  public Order convertToEntity(OrderDTO dto) {
    Order order = new Order(); // Create a new instance of Order (using the default constructor)
    // For new orders, the ID is typically auto-generated, so no need to set it
    order.setDate(dto.getDate()); // Set the order date from the DTO
    order.setTotal(dto.getTotal()); // Set the total amount from the DTO
    return order;
  }

  // Retrieve all orders and convert them to DTOs
  public List<OrderDTO> getAllOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  // Retrieve an order by its ID and convert it to a DTO
  public OrderDTO getOrderById(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    return convertToDTO(order);
  }

  // Create a new order from a DTO
  public OrderDTO createOrder(OrderDTO dto) {
    Order order = convertToEntity(dto);
    Order savedOrder = orderRepository.save(order);
    return convertToDTO(savedOrder);
  }

  // Update an existing order using a DTO
  public OrderDTO updateOrder(Long id, OrderDTO dto) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    order.setDate(dto.getDate());
    order.setTotal(dto.getTotal());
    Order updatedOrder = orderRepository.save(order);
    return convertToDTO(updatedOrder);
  }

  // Delete an order by its ID
  public void deleteOrder(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    orderRepository.delete(order);
  }
}
