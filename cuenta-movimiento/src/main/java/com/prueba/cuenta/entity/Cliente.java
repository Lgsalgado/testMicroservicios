package com.prueba.cuenta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente extends Persona {

    @Column(name = "contrasena", length = 255, nullable = false)
    private String contrasena;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
