package com.example.MicroserviVehiculos.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habitaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    private int numero;

    @ManyToOne
    @JoinColumn(name = "tipo_habitacion")
    private Room_Type tipoHabitacion;

    private boolean disponible;

}
