package com.prueba.cuenta.service;

import com.prueba.cuenta.entity.Cuenta;


public interface CuentaService {

    Cuenta crearCuenta(Cuenta cuenta);
    Cuenta actualizarCuenta(Cuenta cuenta);
    void eliminarCuenta(String numeroCuenta);
    Cuenta obtenerCuentaPorNumero(String numeroCuenta);
}
