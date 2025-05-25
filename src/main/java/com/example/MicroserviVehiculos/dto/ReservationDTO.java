package com.example.MicroserviVehiculos.dto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {
    private Long id;
    private Long clientId;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime reservationDate;
    private String status;
    private Double total;
}
