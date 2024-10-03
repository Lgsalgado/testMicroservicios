package com.prueba.cuenta.controller;

import com.prueba.cuenta.entity.Cuenta;
import com.prueba.cuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        Cuenta nuevaCuenta = cuentaService.crearCuenta(cuenta);
        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable String numeroCuenta) {
        Cuenta cuenta = cuentaService.obtenerCuentaPorNumero(numeroCuenta);

        return new ResponseEntity<>(cuenta, HttpStatus.OK);
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable String numeroCuenta, @RequestBody Cuenta cuenta) {
        cuenta.setNumeroCuenta(numeroCuenta);
        Cuenta cuentaActualizada = cuentaService.actualizarCuenta(cuenta);
        return new ResponseEntity<>(cuentaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable String numeroCuenta) {
        cuentaService.eliminarCuenta(numeroCuenta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
