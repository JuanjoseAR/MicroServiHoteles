package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.ClientRepository;
import com.example.MicroserviVehiculos.model.Client;
import com.example.MicroserviVehiculos.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repo;

    @Override
    public List<Client> listarClientes() {
        return repo.findAll();
    }

    @Override
    public Client obtenerCliente(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
