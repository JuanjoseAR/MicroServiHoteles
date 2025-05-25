package com.example.MicroserviVehiculos.controller;
import com.example.MicroserviVehiculos.model.Client;
import com.example.MicroserviVehiculos.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> listar() {
        return ResponseEntity.ok(service.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerCliente(id));
    }
}
