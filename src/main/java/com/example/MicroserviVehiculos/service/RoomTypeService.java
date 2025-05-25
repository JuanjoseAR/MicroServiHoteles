package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.model.Room_Type;

import java.util.List;

public interface RoomTypeService {
    List<Room_Type> getAllRoomTypes();
    Room_Type getRoomTypeById(Long id);
}
