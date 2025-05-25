package com.example.MicroserviVehiculos.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Room room;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime reservationDate;
    private String status;
    private Double total;
}
