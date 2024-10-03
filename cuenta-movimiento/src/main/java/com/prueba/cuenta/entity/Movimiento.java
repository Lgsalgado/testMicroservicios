package com.prueba.cuenta.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "tipo_movimiento", length = 50, nullable = false)
    private String tipoMovimiento;

    @Column(name = "valor", precision = 15, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "saldo", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "valor_inicial", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldoInicial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "numero_cuenta", nullable = false)
    private Cuenta cuenta;
}
