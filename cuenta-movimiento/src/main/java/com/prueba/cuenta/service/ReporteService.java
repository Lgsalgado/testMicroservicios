package com.prueba.cuenta.service;

import com.prueba.cuenta.dto.ReporteDTO;
import java.time.LocalDate;

public interface ReporteService {
    public ReporteDTO generarReporte(LocalDate fechaInicio, LocalDate fechaFin, Integer identificacion);
}
