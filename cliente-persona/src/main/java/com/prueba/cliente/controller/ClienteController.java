package com.prueba.cliente.controller;

import com.prueba.cliente.entity.Cliente;
import com.prueba.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Crear un nuevo Cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    // Actualizar un Cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Integer clienteId, @RequestBody Cliente cliente) {
        // Primero, obtener el cliente existente
        Cliente existingCliente = clienteService.getClienteById(clienteId);

        // Actualiza los atributos heredados de Persona
        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setGenero(cliente.getGenero());
        existingCliente.setEdad(cliente.getEdad());
        existingCliente.setIdentificacion(cliente.getIdentificacion());
        existingCliente.setDireccion(cliente.getDireccion());
        existingCliente.setTelefono(cliente.getTelefono());

        // Actualiza los atributos de Cliente
        existingCliente.setContrasena(cliente.getContrasena());
        existingCliente.setEstado(cliente.getEstado());

        // Guardar los cambios
        Cliente updatedCliente = clienteService.updateCliente(existingCliente);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    // Eliminar un Cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer clienteId) {
        clienteService.deleteCliente(clienteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener un Cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer clienteId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // Obtener todos los Clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
