package com.prueba.cuenta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "numero_cuenta", length = 20, nullable = false)
    private String numeroCuenta;

    @Column(name = "tipo_cuenta", length = 50, nullable = false)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldoInicial;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}
