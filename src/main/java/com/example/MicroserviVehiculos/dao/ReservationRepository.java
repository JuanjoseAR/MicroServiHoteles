package com.example.MicroserviVehiculos.dao;

import com.example.MicroserviVehiculos.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository  extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClientId(Long clientId);
    boolean existsByRoomIdAndStartDateLessThanAndEndDateGreaterThanAndStatus(
            Long roomId, LocalDate endDate, LocalDate startDate, String status);
}
