package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.FacturaRepository;
import com.example.MicroserviVehiculos.dao.ReservationRepository;
import com.example.MicroserviVehiculos.dto.FacturaDTO;
import com.example.MicroserviVehiculos.model.Factura;
import com.example.MicroserviVehiculos.model.Reservation;
import com.example.MicroserviVehiculos.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepo;
    private final ReservationRepository reservaRepo;

    @Override
    public FacturaDTO generarFactura(Long reservaId) {
        Reservation reserva = reservaRepo.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        Factura factura = Factura.builder()
                .reserva(reserva)
                .fecha(LocalDateTime.now())
                .monto(reserva.getTotal())
                .estado("Pendiente")
                .build();

        return mapToDTO(facturaRepo.save(factura));
    }

    @Override
    public FacturaDTO obtenerFactura(Long id) {
        return facturaRepo.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    private FacturaDTO mapToDTO(Factura f) {
        return FacturaDTO.builder()
                .id(f.getId())
                .reservaId(f.getReserva().getId())
                .fecha(f.getFecha())
                .monto(f.getMonto())
                .estado(f.getEstado())
                .build();
    }
}
