package com.prueba.cuenta.service;

import com.prueba.cuenta.config.SaldoInsuficienteException;
import com.prueba.cuenta.dto.MovimientoDTO;
import com.prueba.cuenta.entity.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoService {

    Movimiento registrarMovimiento(Movimiento movimiento) throws SaldoInsuficienteException;
    //obtener los movimientos por fecha
    List<MovimientoDTO> obtenerMovimientosPorFechas(List<String> numeroCuenta, LocalDate fechaInicio, LocalDate fechaFin);

}
