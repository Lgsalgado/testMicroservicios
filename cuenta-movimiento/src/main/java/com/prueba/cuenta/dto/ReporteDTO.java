package com.prueba.cuenta.dto;

import com.prueba.cuenta.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ReporteDTO {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String nombre;
    private List<CuentasDTO> movimientosPorCuenta;

}
