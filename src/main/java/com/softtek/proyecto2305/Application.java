package com.softtek.proyecto2305;

import com.softtek.proyecto2305.dto.ProductoDto;
import com.softtek.proyecto2305.modelo.Producto;
import com.softtek.proyecto2305.servicio.ClienteServicio;
import com.softtek.proyecto2305.servicio.OrdenServicio;
import com.softtek.proyecto2305.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private OrdenServicio ordenServicio;

    @Autowired
    private Producto producto;



    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    productoServicio.obtenerPrecioPromedioPorSupplier();
    productoServicio.obtenerSumaInventario();
    productoServicio.obtenerSinDescontinuado();

       /*System.out.println("Select * from productos ");
        productoServicio.obtenerTodosLosProductos().forEach(System.out::println);*/
/*
        System.out.println("Select * from clientes ");
        clienteServicio.obtenerClientes().forEach(System.out::println);*/

/*        System.out.println("Select * from ordenes ");
        ordenServicio.obtenerOrdenes().forEach(System.out::println);*/

/*        System.out.println("SELECT product_id, product_name,supplier_id, category_id,units_in_stock FROM products;");
        productoServicio.obtenerInfoProductos().forEach(System.out::println);*/

/*        System.out.println("SELECT order_id, customer_id, order_date FROM orders;");
        ordenServicio.obtenerInfoOrdenes1().forEach(System.out::println);*/
/*
        System.out.println("SELECT order_id, employee_id, order_date FROM orders;");
        ordenServicio.obtenerInfoOrdenes2().forEach(System.out::println);*/

/*        System.out.println("SELECT product_id, product_name, (units_in_stock*unit_price) as valor_inventario FROM products;");
        productoServicio.obtenerInventariosProductos().forEach(System.out::println);*/
/*
        System.out.println("SELECT (unit_price * reorder_level) as punto_reorden FROM products;");
        productoServicio.obtenerPuntoDeReorden().forEach(System.out::println);*/

/*        System.out.println("SELECT product_id,UPPER(product_name)unit_price FROM products;");
        productoServicio.obtenerMayusculas().forEach(System.out::println);*/
/*
        System.out.println("SELECT product_id,product_name,unit_price FROM products WHERE LENGTH(product_name)=10;");
        productoServicio.obtener10Caracteres().forEach(System.out::println);*/
/*
        System.out.println("SELECT LENGTH(product_name) FROM products;");
        productoServicio.obtenerLogintudNombre().forEach(System.out::println);*/

/*
        System.out.println("SELECT LOWER(product_name) FROM products;");
        productoServicio.obtenerMinusculas().forEach(System.out::println);*/

/*        System.out.println("SELECT product_id,UPPER(product_name), unit_price FROM products WHERE LENGTH(product_name)=10;");
        productoServicio.obtener10CaracteresMayusculas().forEach(System.out::println);*/
/*
        System.out.println("SELECT customer_id,company_name,country FROM customers  WHERE country='Spain';");
        clienteServicio.obtenerPaisSpain().forEach(System.out::println);*/
/*
        System.out.println("SELECT customer_id,company_name,country FROM customers WHERE country LIKE 'U%';");
        clienteServicio.obtenerPaisU().forEach(System.out::println);*/

/*        System.out.println("SELECT customer_id,company_name,country FROM customers WHERE country LIKE 'U%' OR country LIKE 'S%' OR country LIKE 'A%';");
        clienteServicio.obtenerPaisS().forEach(System.out::println);*/

/*        System.out.println("SELECT product_id,product_name,unit_price FROM products WHERE unit_price BETWEEN 50 AND 150;");
        productoServicio.obtenerPrecio().forEach(System.out::println);*/

/*        System.out.println("SELECT product_id,product_name,unit_price,units_in_stock FROM products WHERE units_in_stock BETWEEN 50 AND 150;");
        productoServicio.obtenerCantidad().forEach(System.out::println);*/
/*
        System.out.println("SELECT order_id,customer_id,employee_id FROM orders WHERE employee_id IN(1,4,9);");
        ordenServicio.obtenerInfoOrdenes3().forEach(System.out::println);*/

/*        System.out.println("SELECT * FROM products ORDER BY product_name ASC;");
        productoServicio.obtenerNombre().forEach(System.out::println);*/
/*
        System.out.println("SELECT * FROM products ORDER BY category_id ASC,unit_price DESC;");
        productoServicio.obtenerCategoria().forEach(System.out::println);*/
/*
        System.out.println(" //SELECT product_id,product_name,category_id,supplier_id FROM products WHERE unit_price BETWEEN 25 AND 200 ORDER BY category_id, supplier_id");
        productoServicio.obtenerprecioProductos().forEach(System.out::println);*/

/*        System.out.println("SELECT count (product_id) FROM products;");
        System.out.println(productoServicio.obtenerCantidadProductos());*/
/*
        System.out.println("SELECT sum(units_in_stock) FROM products;");
        System.out.println(productoServicio.obtenerCantidadInventarioProductos());*/
/*
        System.out.println("SELECT * FROM products WHERE category_id =1 ORDER BY unit_price DESC;");
        productoServicio.obtenerProductosCategoria1().forEach(System.out::println);*/
/*
        System.out.println("SELECT * FROM customers WHERE city LIKE 'Barcelona' or city LIKE 'Lisboa' ORDER BY company_name DESC;");
        clienteServicio.obtenerClienteBarcelonaLisboa().forEach(System.out::println);*/
/*
        System.out.println("SELECT * FROM  products WHERE unit_price BETWEEN 30 and 60 ORDER BY product_name;");
        productoServicio.obtenerPrecioentre().forEach(System.out::println)*/;

     /*   System.out.println("SELECT max(unit_price) as precio_maximo, min(unit_price) as precio_minimo, avg(unit_price) precio_promedio FROM products;");
        productoServicio.obtenerMaxMinPrecio().forEach(System.out::println);*/

 /*       System.out.println("SELECT count(*) as num_productos FROM products GROUP BY category_id;");
        productoServicio.obtenerNumProductos();*/

/*        System.out.println("SELECT avg(unit_price) as precio_promedio FROM products GROUP BY supplier_id;");
        productoServicio.obtenerPrecioPromedioPorSupplier();*/
/*
        System.out.println("SELECT sum(units_in_stock) as suma_inventario FROM products GROUP BY supplier_id;");
        productoServicio.obtenerSumaInventario();*/
/*
        System.out.println("SELECT customer_id, sum(freight) as suma_envio FROM orders GROUP BY customer_id;");
        ordenServicio.sumaporcliente();*/






    }
}
