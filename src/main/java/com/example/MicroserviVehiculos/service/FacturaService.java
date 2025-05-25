package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.dto.FacturaDTO;

public interface FacturaService {
    FacturaDTO generarFactura(Long reservaId);
    FacturaDTO obtenerFactura(Long id);
}
