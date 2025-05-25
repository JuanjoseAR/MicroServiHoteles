package com.example.MicroserviVehiculos.controller;
import com.example.MicroserviVehiculos.dto.FacturaDTO;
import com.example.MicroserviVehiculos.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;

    @PostMapping("/generar/{reservaId}")
    public ResponseEntity<FacturaDTO> generar(@PathVariable Long reservaId) {
        return ResponseEntity.ok(facturaService.generarFactura(reservaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.obtenerFactura(id));
    }
}
