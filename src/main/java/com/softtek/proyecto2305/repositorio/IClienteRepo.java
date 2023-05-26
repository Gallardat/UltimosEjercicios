package com.softtek.proyecto2305.repositorio;

import com.softtek.proyecto2305.modelo.Cliente;
import com.softtek.proyecto2305.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {



}
