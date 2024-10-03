package com.prueba.cuenta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona { // Marcar como abstracta si no debería instanciarse directamente

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "genero", length = 10, nullable = false)
    private String genero;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "identificacion", length = 20, unique = true, nullable = false)
    private String identificacion;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;
}
