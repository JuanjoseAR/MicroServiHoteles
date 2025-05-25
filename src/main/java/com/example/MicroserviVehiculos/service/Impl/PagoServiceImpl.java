package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.FacturaRepository;
import com.example.MicroserviVehiculos.dao.PagoRepository;
import com.example.MicroserviVehiculos.dto.PagoDTO;
import com.example.MicroserviVehiculos.model.Factura;
import com.example.MicroserviVehiculos.model.Pago;
import com.example.MicroserviVehiculos.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepo;
    private final FacturaRepository facturaRepo;

    @Override
    public PagoDTO registrarPago(PagoDTO dto) {
        Factura factura = facturaRepo.findById(dto.getFacturaId())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        // Paso 1: calcular pagos acumulados
        List<Pago> pagosPrevios = pagoRepo.findByFacturaId(factura.getId());
        double totalPagado = pagosPrevios.stream()
                .filter(p -> p.getEstadoDePago().equalsIgnoreCase("Exitoso"))
                .mapToDouble(Pago::getMonto)
                .sum();

        double nuevoTotal = totalPagado + dto.getMonto();

        // Paso 2: Validar si excede
        if (nuevoTotal > factura.getMonto()) {
            throw new RuntimeException("El pago excede el monto total de la factura");
        }

        // Paso 3: Guardar el nuevo pago
        Pago pago = Pago.builder()
                .factura(factura)
                .monto(dto.getMonto())
                .fechaPago(dto.getFechaPago())
                .metodoDePago(dto.getMetodoDePago())
                .estadoDePago(dto.getEstadoDePago())
                .build();

        pagoRepo.save(pago);

        // Paso 4: Actualizar estado de la factura
        if (dto.getEstadoDePago().equalsIgnoreCase("Exitoso")) {
            if (nuevoTotal == factura.getMonto()) {
                factura.setEstado("Pagada");
            } else {
                factura.setEstado("Parcial");
            }
            facturaRepo.save(factura);
        }

        return mapToDTO(pago);
    }


    @Override
    public List<PagoDTO> listarPagosPorFactura(Long facturaId) {
        return pagoRepo.findByFacturaId(facturaId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PagoDTO mapToDTO(Pago p) {
        return PagoDTO.builder()
                .id(p.getId())
                .facturaId(p.getFactura().getId())
                .monto(p.getMonto())
                .fechaPago(p.getFechaPago())
                .metodoDePago(p.getMetodoDePago())
                .estadoDePago(p.getEstadoDePago())
                .build();
    }
}
