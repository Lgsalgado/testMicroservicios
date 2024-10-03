package com.prueba.cuenta.repository;

import com.prueba.cuenta.dto.MovimientoDTO;
import com.prueba.cuenta.entity.Cuenta;
import com.prueba.cuenta.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query("SELECT new com.prueba.cuenta.dto.MovimientoDTO(m.id, m.fecha, m.tipoMovimiento,m.saldoInicial, m.valor, m.saldo, c.numeroCuenta) " +
            "FROM Movimiento m JOIN m.cuenta c " +
            "WHERE c.numeroCuenta in :numeroCuenta " +
            "AND m.fecha BETWEEN :fechaInicio AND :fechaFin ORDER BY m.fecha desc ")
    List<MovimientoDTO> findMovimientosPorFechaYNumeroCuenta(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                             @Param("fechaFin") LocalDateTime fechaFin,
                                                             @Param("numeroCuenta") List<String> numeroCuenta);

}
