package com.prueba.cuenta.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class MovimientoDTO {
    private Integer id;
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private BigDecimal valorInicial;
    private BigDecimal valor;
    private BigDecimal saldo;
    private String numeroCuenta;

    public MovimientoDTO(Integer id, LocalDateTime fecha, String tipoMovimiento,BigDecimal valorInicial, BigDecimal valor, BigDecimal saldo, String numeroCuenta) {
        this.valorInicial=valorInicial;
        this.id = id;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }
}
