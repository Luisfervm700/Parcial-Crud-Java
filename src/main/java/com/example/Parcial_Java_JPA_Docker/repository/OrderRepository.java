package com.example.Parcial_Java_JPA_Docker.repository;

import com.example.Parcial_Java_JPA_Docker.model.Order;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Order entity.
 * Provides CRUD operations and custom queries for Order objects.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  /**
   * Finds orders by the user's ID.
   *
   * @param usuarioId the ID of the user whose orders are to be retrieved.
   * @return a list of orders for the specified user.
   */
  List<Order> findByUsuarioId(Long usuarioId);

  /**
   * Finds orders within a specified date range.
   *
   * @param startDate the start date of the range.
   * @param endDate   the end date of the range.
   * @return a list of orders that fall between the start and end dates.
   */
  List<Order> findByFechaBetween(LocalDate startDate, LocalDate endDate);
}
