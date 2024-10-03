package com.prueba.cuenta.service.impl;

import com.prueba.cuenta.dto.CuentasDTO;
import com.prueba.cuenta.dto.MovimientoDTO;
import com.prueba.cuenta.dto.ReporteDTO;
import com.prueba.cuenta.entity.Cliente;
import com.prueba.cuenta.entity.Cuenta;
import com.prueba.cuenta.repository.ClienteRepository;
import com.prueba.cuenta.repository.CuentaRepository;
import com.prueba.cuenta.repository.MovimientoRepository;
import com.prueba.cuenta.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public ReporteDTO generarReporte(LocalDate fechaInicio, LocalDate fechaFin, Integer identificacion) {

        // Cliente lanzando una excepción si no se encuentra
        Cliente cliente = clienteRepository.findById(identificacion)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Obtener las cuentas del cliente
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(cliente.getId());

        // Extraer los números de cuenta y saldos
        Map<String, BigDecimal> numerosYSaldo = cuentas.stream()
                .collect(Collectors.toMap(Cuenta::getNumeroCuenta, Cuenta::getSaldoInicial));

        // Convertir fechas a LocalDateTime
        LocalDateTime fechaInicioDateTime = fechaInicio.atStartOfDay();
        LocalDateTime fechaFinDateTime = fechaFin.atTime(LocalTime.MAX);

        // Obtener movimientos por fecha y número de cuenta
        List<MovimientoDTO> movimientos = movimientoRepository.findMovimientosPorFechaYNumeroCuenta(
                fechaInicioDateTime, fechaFinDateTime, numerosYSaldo.keySet().stream().toList());

        // Organizar movimientos por número de cuenta
        Map<String, List<MovimientoDTO>> movimientosPorCuenta = movimientos.stream()
                .collect(Collectors.groupingBy(MovimientoDTO::getNumeroCuenta));

        // Crear la lista de CuentasDTO
        List<CuentasDTO> cuentasDTOList = numerosYSaldo.keySet().stream()
                .map(numeroCuenta -> {
                    CuentasDTO cuentasDTO = new CuentasDTO();
                    cuentasDTO.setNumeroCuenta(numeroCuenta);

                    // Obtener saldo inicial asociado al número de cuenta
                    BigDecimal saldoInicial = numerosYSaldo.get(numeroCuenta);
                    cuentasDTO.setSaldo(saldoInicial);

                    // Obtener movimientos asociados al numero de cuenta
                    List<MovimientoDTO> movimientosDTO = movimientosPorCuenta.getOrDefault(numeroCuenta, List.of());
                    cuentasDTO.setMovimientos(movimientosDTO);

                    return cuentasDTO;
                })
                .toList();

        // Mapear DTO
        ReporteDTO reporte = new ReporteDTO();
        reporte.setNombre(cliente.getNombre());
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.setMovimientosPorCuenta(cuentasDTOList);

        return reporte;
    }
}
