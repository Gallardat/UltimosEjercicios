package com.softtek.proyecto2305.repositorio;

import com.softtek.proyecto2305.modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepo extends JpaRepository<Orden, Integer> {

}
