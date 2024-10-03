package com.prueba.cuenta.repository;


import com.prueba.cuenta.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}