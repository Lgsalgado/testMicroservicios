package com.prueba.cuenta.service.impl;

import com.prueba.cuenta.config.SaldoInsuficienteException;
import com.prueba.cuenta.dto.MovimientoDTO;
import com.prueba.cuenta.entity.Cuenta;
import com.prueba.cuenta.entity.Movimiento;
import com.prueba.cuenta.repository.CuentaRepository;
import com.prueba.cuenta.repository.MovimientoRepository;
import com.prueba.cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Movimiento registrarMovimiento(Movimiento movimiento) throws SaldoInsuficienteException {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        movimiento.setSaldoInicial(cuenta.getSaldoInicial()); //se toma saldo actual de la cuenta y se lo coloca en movimiento
        movimiento.setCuenta(cuenta);
        BigDecimal nuevoSaldo = cuenta.getSaldoInicial().add(movimiento.getValor());

        if(movimiento.getValor().compareTo(BigDecimal.valueOf(0))<0){
            movimiento.setTipoMovimiento("RETIRO");
        }else {movimiento.setTipoMovimiento("DEPOSITO");}
        // Verificar si hay suficiente saldo
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible");
        }

        // Actualizar el saldo de la cuenta
        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        // Registrar el movimiento con el saldo actualizado
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(LocalDateTime.now());

        return movimientoRepository.save(movimiento);
    }

    @Override
    public List<MovimientoDTO> obtenerMovimientosPorFechas(List<String> numeroCuenta, LocalDate fechaInicio, LocalDate fechaFin) {
        // Convertir LocalDate a LocalDateTime al inicio del día
        LocalDateTime fechaInicioDateTime = fechaInicio.atStartOfDay();

        // Convertir LocalDate a LocalDateTime al final del día
        LocalDateTime fechaFinDateTime = fechaFin.atTime(LocalTime.MAX);

        return movimientoRepository.findMovimientosPorFechaYNumeroCuenta( fechaInicioDateTime, fechaFinDateTime,numeroCuenta);
    }


}