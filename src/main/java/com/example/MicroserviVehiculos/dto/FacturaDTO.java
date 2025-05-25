package com.example.MicroserviVehiculos.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDTO {
    private Long id;
    private Long reservaId;
    private LocalDateTime fecha;
    private Double monto;
    private String estado;
}
