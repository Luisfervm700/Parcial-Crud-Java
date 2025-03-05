package com.example.Parcial_Java_JPA_Docker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Parcial_Java_JPA_Docker.model.Order;
import com.example.Parcial_Java_JPA_Docker.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;

  // Get all orders
  @GetMapping
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  // Get an order by ID
  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    return ResponseEntity.ok(order);
  }

  // Create a new order
  @PostMapping
  public Order createOrder(@RequestBody Order order) {
    return orderRepository.save(order);
  }

  // Update an existing order
  @PutMapping("/{id}")
  public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    order.setDate(orderDetails.getDate());
    order.setTotal(orderDetails.getTotal());
    // Update other attributes or relationships if necessary
    Order updatedOrder = orderRepository.save(order);
    return ResponseEntity.ok(updatedOrder);
  }

  // Delete an order
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    orderRepository.delete(order);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
