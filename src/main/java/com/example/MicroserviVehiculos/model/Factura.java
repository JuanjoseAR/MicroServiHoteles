package com.example.MicroserviVehiculos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reservation reserva;

    private LocalDateTime fecha;

    private Double monto;

    private String estado; // "Pendiente", "Pagada", etc.
}
