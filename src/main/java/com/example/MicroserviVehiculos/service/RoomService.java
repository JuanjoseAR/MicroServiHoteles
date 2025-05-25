package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(Long id);
}
