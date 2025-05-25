package com.example.MicroserviVehiculos.dao;

import com.example.MicroserviVehiculos.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> { }
