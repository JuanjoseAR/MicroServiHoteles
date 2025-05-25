package com.example.MicroserviVehiculos.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tipo_de_habitaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precioPorNoche;
    private Integer capacidad;
    private String descripcion;
}
