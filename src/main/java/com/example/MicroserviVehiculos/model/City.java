package com.example.MicroserviVehiculos.model;


import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "ciudad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//spring.application.name=MicroserviHotels
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
