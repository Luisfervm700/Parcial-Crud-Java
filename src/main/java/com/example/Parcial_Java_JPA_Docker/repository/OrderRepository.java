package com.example.Parcial_Java_JPA_Docker.repository;

import com.example.Parcial_Java_JPA_Docker.model.Order;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Buscar órdenes por el ID del usuario
    List<Order> findByUsuarioId(Long usuarioId);

    // Buscar órdenes en un rango de fechas
    List<Order> findByFechaBetween(LocalDate startDate, LocalDate endDate);
}
