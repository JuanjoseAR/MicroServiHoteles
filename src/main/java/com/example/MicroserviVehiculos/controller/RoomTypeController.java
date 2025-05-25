package com.example.MicroserviVehiculos.controller;

import com.example.MicroserviVehiculos.model.Room_Type;
import com.example.MicroserviVehiculos.service.RoomTypeService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-types")
@RequiredArgsConstructor
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    @GetMapping
    public ResponseEntity<List<Room_Type>> getAllRoomTypes() {
        return ResponseEntity.ok(roomTypeService.getAllRoomTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room_Type> getRoomTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getRoomTypeById(id));
    }
}
