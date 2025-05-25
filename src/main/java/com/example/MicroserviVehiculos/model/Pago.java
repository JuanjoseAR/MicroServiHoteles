package com.example.MicroserviVehiculos.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    private Double monto;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    private String metodoDePago; // "Tarjeta", "Transferencia", etc.

    private String estadoDePago; // "Exitoso", "Fallido"
}
