package com.prueba.cuenta.config;


public class SaldoInsuficienteException extends Throwable {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}