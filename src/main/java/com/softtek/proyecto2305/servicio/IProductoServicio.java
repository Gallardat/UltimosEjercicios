package com.softtek.proyecto2305.servicio;

import com.softtek.proyecto2305.modelo.Producto;
import com.softtek.proyecto2305.repositorio.ICrud;
import com.softtek.proyecto2305.repositorio.IGenericRepo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductoServicio extends ICrud<Producto, Short>{

    public List<Producto> obtenerTodosLosProductos();

}