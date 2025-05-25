package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.RoomTypeRepository;
import com.example.MicroserviVehiculos.model.Room_Type;
import com.example.MicroserviVehiculos.service.RoomTypeService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomTypeServiceImpl  implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepo;

    @Override
    public List<Room_Type> getAllRoomTypes() {
        return roomTypeRepo.findAll();
    }

    @Override
    public Room_Type getRoomTypeById(Long id) {
        return roomTypeRepo.findById(id).orElseThrow(() -> new RuntimeException("Room type not found"));
    }
}