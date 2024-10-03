package com.prueba.cuenta.service.impl;
import com.prueba.cuenta.config.SaldoInsuficienteException;
import com.prueba.cuenta.entity.Cuenta;
import com.prueba.cuenta.entity.Movimiento;
import com.prueba.cuenta.repository.CuentaRepository;
import com.prueba.cuenta.repository.MovimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovimientoServiceImplTest {

    @InjectMocks
    private MovimientoServiceImpl movimientoService;

    @Mock
    private CuentaRepository cuentaRepository;

    @Mock
    private MovimientoRepository movimientoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarMovimiento_depositoExitoso() throws SaldoInsuficienteException {

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        cuenta.setSaldoInicial(new BigDecimal("1000"));

        Movimiento movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        movimiento.setValor(new BigDecimal("500")); // Un depósito

        // Simula el comportamiento de los repositorios
        when(cuentaRepository.findById(cuenta.getNumeroCuenta())).thenReturn(Optional.of(cuenta));
        when(movimientoRepository.save(any(Movimiento.class))).thenReturn(movimiento);

        // EM
        Movimiento resultado = movimientoService.registrarMovimiento(movimiento);

        // VR
        assertNotNull(resultado);
        assertEquals(new BigDecimal("1500"), cuenta.getSaldoInicial()); // El nuevo saldo después del depósito
        assertEquals(new BigDecimal("1500"), resultado.getSaldo());     // El saldo actualizado en el movimiento
        assertEquals("DEPOSITO", resultado.getTipoMovimiento());       // Verificar el tipo de movimiento

        // Verificar
        verify(cuentaRepository, times(1)).findById(cuenta.getNumeroCuenta());
        verify(cuentaRepository, times(1)).save(cuenta);
        verify(movimientoRepository, times(1)).save(movimiento);
    }

    @Test
    void testRegistrarMovimiento_retiroExitoso() throws SaldoInsuficienteException {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        cuenta.setSaldoInicial(new BigDecimal("1000"));

        Movimiento movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        movimiento.setValor(new BigDecimal("-500")); // Un retiro

        //comportamiento de los repositorios
        when(cuentaRepository.findById(cuenta.getNumeroCuenta())).thenReturn(Optional.of(cuenta));
        when(movimientoRepository.save(any(Movimiento.class))).thenReturn(movimiento);

        // EM
        Movimiento resultado = movimientoService.registrarMovimiento(movimiento);

        // VR
        assertNotNull(resultado);
        assertEquals(new BigDecimal("500"), cuenta.getSaldoInicial());  // El nuevo saldo después del retiro
        assertEquals(new BigDecimal("500"), resultado.getSaldo());      // El saldo actualizado en el movimiento
        assertEquals("RETIRO", resultado.getTipoMovimiento());          // Verificar el tipo de movimiento

        // Verificar interacciones con los mocks
        verify(cuentaRepository, times(1)).findById(cuenta.getNumeroCuenta());
        verify(cuentaRepository, times(1)).save(cuenta);
        verify(movimientoRepository, times(1)).save(movimiento);
    }

    @Test
    void testRegistrarMovimiento_saldoInsuficiente() {

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        cuenta.setSaldoInicial(new BigDecimal("100"));

        Movimiento movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        movimiento.setValor(new BigDecimal("-200")); // Un retiro mayor al saldo actual

        //comportamiento de los repositorios
        when(cuentaRepository.findById(cuenta.getNumeroCuenta())).thenReturn(Optional.of(cuenta));

        // VExcepcion
        SaldoInsuficienteException exception = assertThrows(SaldoInsuficienteException.class, () ->
                movimientoService.registrarMovimiento(movimiento));

        assertEquals("Saldo no disponible", exception.getMessage());

        // VRepositorio
        verify(cuentaRepository, times(1)).findById(cuenta.getNumeroCuenta());
        verify(cuentaRepository, times(0)).save(any(Cuenta.class));
        verify(movimientoRepository, times(0)).save(any(Movimiento.class));
    }
}
