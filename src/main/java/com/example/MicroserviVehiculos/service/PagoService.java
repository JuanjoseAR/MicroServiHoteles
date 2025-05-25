package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.dto.PagoDTO;

import java.util.List;

public interface PagoService {
    PagoDTO registrarPago(PagoDTO dto);
    List<PagoDTO> listarPagosPorFactura(Long facturaId);
}
