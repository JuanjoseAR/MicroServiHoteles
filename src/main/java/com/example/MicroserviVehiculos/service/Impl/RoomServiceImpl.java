package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.RoomRepository;
import com.example.MicroserviVehiculos.dto.RoomDTO;
import com.example.MicroserviVehiculos.model.Room;
import com.example.MicroserviVehiculos.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepo;

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        return roomRepo.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    private RoomDTO mapToDTO(Room r) {
        return RoomDTO.builder()
                .id(r.getId())
                .hotelId(r.getHotel().getId())
                .number(r.getNumero())
                .roomTypeId(r.getTipoHabitacion().getId())
                .available(r.isDisponible())
                .build();
    }
}