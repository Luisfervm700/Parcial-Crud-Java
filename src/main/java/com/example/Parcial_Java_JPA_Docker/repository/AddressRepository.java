package com.example.Parcial_Java_JPA_Docker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Parcial_Java_JPA_Docker.model.Address;

/**
 * Repository interface for the Address entity.
 * Provides CRUD operations and custom queries for Address objects.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  /**
   * Finds addresses by city.
   *
   * @param ciudad the city to search for.
   * @return a list of addresses in the specified city.
   */
  List<Address> findByCiudad(String ciudad);

  /**
   * Finds addresses by country.
   *
   * @param pais the country to search for.
   * @return a list of addresses in the specified country.
   */
  List<Address> findByPais(String pais);
}
