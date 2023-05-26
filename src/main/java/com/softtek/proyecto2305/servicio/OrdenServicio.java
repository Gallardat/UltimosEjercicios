package com.softtek.proyecto2305.servicio;

import com.softtek.proyecto2305.modelo.Cliente;
import com.softtek.proyecto2305.modelo.Orden;
import com.softtek.proyecto2305.repositorio.IOrdenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrdenServicio implements IOrderServicio{

    @Autowired
    IOrdenRepo repo;
    @Override
    public List<Orden> obtenerOrdenes() {
        return repo.findAll();
    }



    //--Crear una consulta para obtener el IdOrden, IdCustomer, Fecha de la orden de la tabla de ordenes.

    public List<String> obtenerInfoOrdenes1() {
        List<Orden> ordenes = obtenerOrdenes();
        List<String> resultado = ordenes.stream()
                .map(orden -> orden.getIdOrden()+
                        " IDCliente "+orden.getIdCliente()+
                        " Fecha de orden "+orden.getFechaOrden())
                .collect(Collectors.toList());
        return resultado;
    }



    //--Crear una consulta para obtener el OrderId, EmployeeId, Fecha de la orden.

    public List<String> obtenerInfoOrdenes2() {
        List<Orden> ordenes = obtenerOrdenes();
        List<String> resultado = ordenes.stream()
              .map(orden -> orden.getIdOrden()+
                        " IDEmpleado"+orden.getIdEmpleado()+
                        " Fecha de orden "+orden.getFechaOrden())
              .collect(Collectors.toList());
        return resultado;
    }
    // SELECT order_id,customer_id,employee_id FROM orders WHERE employee_id IN(1,4,9);
    public List<String> obtenerInfoOrdenes3() {
        List<Orden> ordenes = obtenerOrdenes();
        List<String> resultado = ordenes.stream()
                .filter(orden->List.of(1,4,9).contains(orden.getIdEmpleado()))
              .map(orden -> "IdOrder"+orden.getIdOrden()+
                        " IDCliente "+orden.getIdCliente()+
                        " IDEmpleado "+orden.getIdEmpleado())
              .collect(Collectors.toList());
        return resultado;
    }
    //SELECT * FROM orders WHERE employee_id IN(2,4) ORDER BY order_date ASC;

    public List<String> obtenerordenesempleado() {
        List<Orden> ordenes = obtenerOrdenes();
        List<String> resultado = ordenes.stream()
               .filter(orden->List.of(2,4).contains(orden.getIdEmpleado()))
             .map(orden -> "IdOrder"+orden.getIdOrden()+
                        " IDCliente "+orden.getIdCliente()+
                        " IDEmpleado "+orden.getIdEmpleado())
             .collect(Collectors.toList());
        return resultado;
    }

    //Obtener la suma del envío (freight) por cliente

    public Map<String, Double> sumaporcliente() {
        List<Orden> ordenes = obtenerOrdenes();
        Map<String, Double> respuesta= ordenes.stream()
                .collect(Collectors.groupingBy(Orden::getIdCliente, Collectors.summingDouble(Orden::getTransporte)));

        respuesta.forEach((idCliente, suma) -> System.out.println(idCliente + " SUMA" + suma));
        return respuesta;
    }
}
