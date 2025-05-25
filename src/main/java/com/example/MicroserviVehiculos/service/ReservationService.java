package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getByClientId(Long clientId);
    ReservationDTO getById(Long id);
    ReservationDTO updateReservation(Long id, ReservationDTO dto);
    void cancelReservation(Long id);
    ReservationDTO createReservation(ReservationDTO dto);
}
