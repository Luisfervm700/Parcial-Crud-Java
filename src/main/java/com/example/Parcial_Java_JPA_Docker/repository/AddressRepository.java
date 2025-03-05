package com.example.Parcial_Java_JPA_Docker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Parcial_Java_JPA_Docker.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Buscar direcciones por ciudad
    List<Address> findByCiudad(String ciudad);
    
    // Buscar direcciones por país
    List<Address> findByPais(String pais);
}
