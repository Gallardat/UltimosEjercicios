package com.softtek.proyecto2305.controlador;

import com.softtek.proyecto2305.dto.ProductoDto;
import com.softtek.proyecto2305.servicio.IProductoServicio;
import com.softtek.proyecto2305.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoControlador {
    @Autowired
    private ProductoServicio servicio;
    @GetMapping("/promediosproveedor")
    public List<ProductoDto> promedioPorProveedor() throws Exception {
    return servicio.obtenerPrecioPromedioPorSupplier();
    }

}
