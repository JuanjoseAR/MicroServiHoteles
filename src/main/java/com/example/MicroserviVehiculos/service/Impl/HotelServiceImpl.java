package com.example.MicroserviVehiculos.service.Impl;
import com.example.MicroserviVehiculos.dao.HotelRepository;
import com.example.MicroserviVehiculos.model.Hotel;
import com.example.MicroserviVehiculos.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepo;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepo.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
    }
}