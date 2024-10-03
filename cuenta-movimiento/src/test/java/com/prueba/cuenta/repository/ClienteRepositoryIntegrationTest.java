package com.prueba.cuenta.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.prueba.cuenta.entity.Cliente;

@DataJpaTest
public class ClienteRepositoryIntegrationTest {
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testSaveCliente() {
        // Crear un nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Gabriel Salgado");
        cliente.setEdad(19);
        cliente.setDireccion("Mena dos");
        cliente.setContrasena("12345678");
        cliente.setEstado(true);

        // Guardar el cliente en la base de datos
        Cliente savedCliente = clienteRepository.save(cliente);

        // Verificar que el cliente se guarde correctamente
        assertNotNull(savedCliente.getId(), "El ID del cliente no debería ser nulo");
    }
}
