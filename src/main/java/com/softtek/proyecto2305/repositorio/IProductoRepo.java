package com.softtek.proyecto2305.repositorio;

import com.softtek.proyecto2305.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IProductoRepo extends JpaRepository<Producto, Short> {


}
