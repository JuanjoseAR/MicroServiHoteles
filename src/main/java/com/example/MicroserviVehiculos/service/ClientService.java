package com.example.MicroserviVehiculos.service;

import com.example.MicroserviVehiculos.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> listarClientes();
    Client obtenerCliente(Long id);
}
