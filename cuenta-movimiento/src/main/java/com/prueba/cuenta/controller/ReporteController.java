package com.prueba.cuenta.controller;

import com.prueba.cuenta.dto.ReporteDTO;
import com.prueba.cuenta.repository.ClienteRepository;
import com.prueba.cuenta.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;



@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public ResponseEntity<ReporteDTO> generarReporte(
            @RequestParam("fecha") String rangoFechas,
            @RequestParam("cliente") Integer cliente) {
        // Descomponer el rango de fechas
        String[] fechas = rangoFechas.split(";");
        LocalDate fechaInicio = LocalDate.parse(fechas[0]);
        LocalDate fechaFin = LocalDate.parse(fechas[1]);

        ReporteDTO reporte = reporteService.generarReporte(fechaInicio,fechaFin,cliente);

        return ResponseEntity.ok(reporte);
    }
}

