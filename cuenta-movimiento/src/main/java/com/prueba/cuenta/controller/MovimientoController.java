package com.prueba.cuenta.controller;

import com.prueba.cuenta.config.SaldoInsuficienteException;
import com.prueba.cuenta.dto.MovimientoDTO;
import com.prueba.cuenta.entity.Movimiento;
import com.prueba.cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento nuevoMovimiento = movimientoService.registrarMovimiento(movimiento);
            return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (SaldoInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    //obtener movimientos por rango de fechas
    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<List<MovimientoDTO>> obtenerMovimientosPorFechas(
            @PathVariable String numeroCuenta,
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {

        List<String> cuenta=new ArrayList<>();
        cuenta.add(numeroCuenta);
        List<MovimientoDTO> movimientos = movimientoService.obtenerMovimientosPorFechas(cuenta, fechaInicio, fechaFin);
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }
}

