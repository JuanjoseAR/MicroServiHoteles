package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.CityRepository;
import com.example.MicroserviVehiculos.model.City;
import com.example.MicroserviVehiculos.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepo;

    @Override
    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepo.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
    }
}
