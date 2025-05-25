package com.example.MicroserviVehiculos.controller;

import com.example.MicroserviVehiculos.dto.PagoDTO;
import com.example.MicroserviVehiculos.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> registrarPago(@RequestBody PagoDTO dto) {
        return ResponseEntity.ok(pagoService.registrarPago(dto));
    }

    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<List<PagoDTO>> listarPagos(@PathVariable Long facturaId) {
        return ResponseEntity.ok(pagoService.listarPagosPorFactura(facturaId));
    }
}
