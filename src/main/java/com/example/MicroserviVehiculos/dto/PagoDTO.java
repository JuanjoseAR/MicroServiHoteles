package com.example.MicroserviVehiculos.dto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoDTO {
    private Long id;
    private Long facturaId;
    private Double monto;
    private LocalDateTime fechaPago;
    private String metodoDePago;
    private String estadoDePago;
}
