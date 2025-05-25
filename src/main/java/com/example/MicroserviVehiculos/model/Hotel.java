package com.example.MicroserviVehiculos.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hoteles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private City ciudad;

    private String telefono;
    private String email;
    private int estrellas;
    private String descripcion;
}
