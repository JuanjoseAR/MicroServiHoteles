package com.example.MicroserviVehiculos.dao;

import com.example.MicroserviVehiculos.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository  extends JpaRepository<Factura, Long> {
    Factura findByReservaId(Long reservaId);
}
