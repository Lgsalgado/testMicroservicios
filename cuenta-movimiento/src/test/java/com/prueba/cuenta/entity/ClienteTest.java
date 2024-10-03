package com.prueba.cuenta.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        // Inicializamos la entidad Cliente para cada prueba
        cliente = new Cliente();
    }

    @Test
    public void testClienteProperties() {
        //valores a las propiedades de Cliente
        cliente.setNombre("Gabriel Salgado");
        cliente.setEdad(19);
        cliente.setDireccion("Mena dos");
        cliente.setContrasena("12345678");
        cliente.setEstado(true);

        //las propiedades heredadas de Persona
        assertNotNull(cliente.getNombre(), "El nombre no debe ser nulo");
        assertEquals("Gabriel Salgado", cliente.getNombre(), "El nombre debe ser 'Gabriel Salgado'");
        assertEquals(19, cliente.getEdad(), "La edad debería ser 19");
        assertEquals("Mena dos", cliente.getDireccion(), "La dirección debe ser 'Mena dos'");

        //las propiedades específicas de Cliente
        assertEquals("12345678", cliente.getContrasena(), "La contraseña debe ser '12345678'");
        assertEquals(true, cliente.getEstado(), "El estado debe ser 'true'");
    }
}
