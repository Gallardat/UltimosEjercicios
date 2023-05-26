package com.softtek.proyecto2305.servicio;

import com.softtek.proyecto2305.modelo.Cliente;
import com.softtek.proyecto2305.modelo.Orden;
import com.softtek.proyecto2305.repositorio.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ClienteServicio implements IClienteServicio {

    @Autowired
    IClienteRepo clienteRepo;


    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepo.findAll();
    }


    //Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais Obtener los clientes cuyo pais sea Spain


    public List<String> obtenerPaisSpain() {
        List<Cliente> clientes = obtenerClientes();
        List<String> resultado = clientes.stream().filter(cliente -> cliente.getPais().equals("Spain"))
                .map(cliente -> "idcliente: " + cliente.getIdCliente() +
                        " Nombre de companñia: " + cliente.getNombreCompania() +
                        " Pais: " + cliente.getPais()).
                collect(Collectors.toList());

        return resultado;
    }

    //SELECT customer_id,company_name,country FROM customers WHERE country LIKE 'U%';
    public List<String> obtenerPaisU() {
        List<Cliente> clientes = obtenerClientes();
        List<String> resultado = clientes.stream().filter(cliente -> cliente.getPais().startsWith("U"))
                .map(cliente -> "idcliente: " + cliente.getIdCliente() +
                        " Nombre de companñia: " + cliente.getNombreCompania() +
                        " Pais: " + cliente.getPais()).
                collect(Collectors.toList());

        return resultado;
    }

    //SELECT customer_id,company_name,country FROM customers WHERE country LIKE 'U%' OR country LIKE 'S%' OR country LIKE 'A%';
    public List<String> obtenerPaisS() {
        List<Cliente> clientes = obtenerClientes();
        List<String> resultado = clientes.stream()
                .filter(cliente -> cliente.getPais().startsWith("S") ||
                        cliente.getPais().startsWith("U") ||
                        cliente.getPais().startsWith("A"))
                .map(cliente -> "idcliente: " + cliente.getIdCliente() +
                        " Nombre de companñia: " + cliente.getNombreCompania() +
                        " Pais: " + cliente.getPais()).
                collect(Collectors.toList());

        return resultado;

    }

    //SELECT customer_id,company_name,city,country FROM customers  ORDER BY country, city;

    public List<Cliente> ordenarCiudadPais() {
        List<Cliente> clientes = obtenerClientes();
        List<Cliente> resultado = clientes.stream()
                .sorted(Comparator.comparing(Cliente::getPais)
                        .thenComparing(Cliente::getCiudad))
                .collect(Collectors.toList());
        return resultado;

    }

//--Obtener los datos de los clientes(Customers) ordenados descendentemente por nombre(CompanyName) que se encuentren en la ciudad(city) de barcelona, Lisboa
//
//SELECT * FROM customers WHERE city LIKE 'Barcelona' or city LIKE 'Lisboa' ORDER BY company_name DESC;
    public List<Cliente> obtenerClienteBarcelonaLisboa() {
        List<Cliente> clientes = obtenerClientes();
        List<Cliente> resultado = clientes.stream()
                .filter(cliente -> cliente.getCiudad().startsWith("Barcelona") ||
                        cliente.getCiudad().startsWith("Lisboa"))
               .sorted(Comparator.comparing(Cliente::getNombreCompania)
                      .thenComparing(Cliente::getCiudad))
              .collect(Collectors.toList());
        return resultado;
    }


}
