package com.prueba.cliente.service;

import com.prueba.cliente.entity.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
    void deleteCliente(Integer clienteId);
    Cliente getClienteById(Integer clienteId);
    List<Cliente> getAllClientes();
}
