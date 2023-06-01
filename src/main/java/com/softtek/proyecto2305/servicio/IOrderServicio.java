package com.softtek.proyecto2305.servicio;

import com.softtek.proyecto2305.modelo.Orden;
import com.softtek.proyecto2305.repositorio.ICrud;

import java.util.List;

public interface IOrderServicio extends ICrud<Orden, Short> {

    List<Orden> obtenerOrdenes();


}
