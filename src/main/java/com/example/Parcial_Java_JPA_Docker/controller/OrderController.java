package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Order;
import com.example.Parcial_Java_JPA_Docker.repository.OrderRepository;

/**
 * REST Controller for the Order entity.
 * Provides endpoints to retrieve, create, update, and delete orders.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;

  /**
   * Retrieve all orders.
   *
   * @return A list of all orders.
   */
  @GetMapping
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  /**
   * Retrieve an order by its ID.
   *
   * @param id The ID of the order to retrieve.
   * @return ResponseEntity containing the found order.
   * @throws RuntimeException if the order is not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    return ResponseEntity.ok(order);
  }

  /**
   * Create a new order.
   *
   * @param order The Order object provided in the request body.
   * @return The created order.
   */
  @PostMapping
  public Order createOrder(@RequestBody Order order) {
    return orderRepository.save(order);
  }

  /**
   * Update an existing order.
   *
   * @param id           The ID of the order to update.
   * @param orderDetails The new details for the order.
   * @return ResponseEntity with the updated order.
   * @throws RuntimeException if the order is not found.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
    // Find the order or throw an exception if not found
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));

    // Update order attributes
    order.setDate(orderDetails.getDate());
    order.setTotal(orderDetails.getTotal());
    // Update other attributes or relationships if necessary

    // Save and return the updated order
    Order updatedOrder = orderRepository.save(order);
    return ResponseEntity.ok(updatedOrder);
  }

  /**
   * Delete an order by its ID.
   *
   * @param id The ID of the order to delete.
   * @return ResponseEntity with a map indicating that the deletion was
   *         successful.
   * @throws RuntimeException if the order is not found.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id) {
    // Find the order or throw an exception if not found
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));

    // Delete the found order
    orderRepository.delete(order);

    // Prepare the response indicating successful deletion
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
