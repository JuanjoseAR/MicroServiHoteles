package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
}
