package com.example.MicroserviVehiculos.dao;

import com.example.MicroserviVehiculos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
