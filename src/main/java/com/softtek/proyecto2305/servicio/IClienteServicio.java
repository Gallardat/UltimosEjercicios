package com.softtek.proyecto2305.servicio;

import com.softtek.proyecto2305.modelo.Cliente;
import com.softtek.proyecto2305.modelo.Orden;
import com.softtek.proyecto2305.repositorio.ICrud;

import java.util.List;

public interface IClienteServicio extends ICrud<Cliente,Short> {

    List<Cliente> obtenerClientes();

}
