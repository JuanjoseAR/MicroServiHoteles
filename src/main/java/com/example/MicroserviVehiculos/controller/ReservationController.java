package com.example.MicroserviVehiculos.controller;
import com.example.MicroserviVehiculos.dto.ReservationDTO;
import com.example.MicroserviVehiculos.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    // Obtener todas las reservas de un cliente
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ReservationDTO>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(reservationService.getByClientId(clientId));
    }

    // Obtener una reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    // Modificar una reserva activa
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> update(@PathVariable Long id, @RequestBody ReservationDTO dto) {
        return ResponseEntity.ok(reservationService.updateReservation(id, dto));
    }

    // Cancelar una reserva
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> create(@RequestBody ReservationDTO dto) {
        return ResponseEntity.ok(reservationService.createReservation(dto));
    }
}
