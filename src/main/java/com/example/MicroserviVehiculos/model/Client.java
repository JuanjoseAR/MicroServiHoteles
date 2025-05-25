package com.example.MicroserviVehiculos.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;

    @Column(name = "licencia_conducir")
    private String licenciaConducir;

    private String direccion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
}
