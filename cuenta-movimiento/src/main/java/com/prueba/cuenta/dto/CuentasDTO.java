package com.prueba.cuenta.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class CuentasDTO {
    private BigDecimal saldo;
    private String numeroCuenta;
    private List<MovimientoDTO> movimientos;
}
