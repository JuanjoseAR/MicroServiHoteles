package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
     City getCityById(Long id);
}
