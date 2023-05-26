package com.softtek.proyecto2305.servicio;

import com.softtek.proyecto2305.modelo.Producto;
import com.softtek.proyecto2305.repositorio.IProductoRepo;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private  IProductoRepo productoRepo;



    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepo.findAll();
    }

    //-- Obtenerr una consulta con Productid, productname, supplierid, categoryId, UnistsinStock, UnitPrice
    public List<String> obtenerInfoProductos() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
                .map(producto->producto.getIdProductos()+" NombreProducto  "+
                        producto.getNombreProducto()+" Proveedor  "+
                        producto.getIdSupplier()+" Idcategoria  "+
                        producto.getIdCategoria()+" UnidadesEnstock"+
                        producto.getUnidadesEnStock()+" PrecioUnitario  "+
                        producto.getPrecioUnitario()+" ")
                .collect(Collectors.toList());
        return resultado;
    }

    //--Obtener una consulta con Productid, productname y valor del inventario, valor inventrio (UnitsinStock * UnitPrice)

    public List<String> obtenerInventariosProductos() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
               .map(producto->producto.getIdProductos()+" NombreProducto: "+
                        producto.getNombreProducto()+" Unidades en stock: "+
                       producto.getUnidadesEnStock()+" precio unitario: "+
                       producto.getPrecioUnitario()+" Valor de intentario->"+
                       (producto.getUnidadesEnStock()*producto.getPrecioUnitario()))
               .collect(Collectors.toList());
        return resultado;
    }

    //-- Cuanto vale el punto de reorden


    public List<String> obtenerPuntoDeReorden() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
              .map(producto->"Punto de reorden: "+
                      (producto.getPrecioUnitario()*(producto.getNivelOrden()!= null ? producto.getNivelOrden() : 0)))
              .collect(Collectors.toList());
        return resultado;
    }

    //-- Mostrar una consulta con Productid, productname y precio, el nombre del producto debe estar en mayuscula


    public List<String> obtenerMayusculas() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
              .map(producto->"IdProducto "+producto.getIdProductos()+
                      "nombre de producto "+producto.getNombreProducto().toUpperCase())
              .collect(Collectors.toList());
        return resultado;
    }
//-- Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres */

    public List<String> obtener10Caracteres() {

        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream().
                map(producto->"IdProducto "+producto.getIdProductos()+
                        "nombre de producto "+producto.getNombreProducto().substring(0, Math.min(producto.getNombreProducto().length(), 10)))
              .collect(Collectors.toList());
        return resultado;
    }

    //--Obtener una consulta que muestre la longitud del nombre del producto

    public List<String> obtenerLogintudNombre() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
                .map(producto->producto.getIdProductos()+
                        producto.getNombreProducto()+" Logintud Nombre Producto  "+
                        producto.getNombreProducto().length())
               .collect(Collectors.toList());
        return resultado;
    }

    //--Obtener una consulta de la tabla de productos que muestre el nombre en minúscula

    public List<String> obtenerMinusculas() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
                .map(producto->"IdProducto "+producto.getIdProductos()+
                        "nombre de producto "+producto.getNombreProducto().toLowerCase())
                .collect(Collectors.toList());
        return resultado;
    }
    //Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres y se deben mostrar en mayúscula */
    public List<String> obtener10CaracteresMayusculas() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream().
                map(producto->producto.getIdProductos()
                        +producto.getPrecioUnitario()+
                        (producto.getNombreProducto().substring(0, Math.min(producto.getNombreProducto().length(), 10)).toUpperCase()))
                .collect(Collectors.toList());
        return resultado;
    }

    //SELECT product_id,product_name,unit_price FROM products WHERE unit_price BETWEEN 50 AND 150;

    public List<String> obtenerPrecio(){
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
                .filter(producto->producto.getPrecioUnitario()>=50 && producto.getPrecioUnitario() <=150)
                .map(producto->"Idprodcuto "+producto.getIdProductos()+
                        " nombre producto "+producto.getNombreProducto()+
                        " precio unitario "+producto.getPrecioUnitario())
                .collect(Collectors.toList());
        return resultado;
    }
    //SELECT product_id,product_name,unit_price,units_in_stock FROM products WHERE units_in_stock BETWEEN 50 AND 150;
    public List<String> obtenerCantidad(){
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
               .filter(producto->producto.getUnidadesEnStock()>=50 && producto.getUnidadesEnStock() <=150)
               .map(producto->"Idprodcuto "+producto.getIdProductos()+
                        " nombre producto "+producto.getNombreProducto()+
                        " unidades en stock "+producto.getUnidadesEnStock()+
                       " precio unitario "+producto.getPrecioUnitario())
               .collect(Collectors.toList());
        return resultado;
    }
        //SELECT * FROM products ORDER BY product_name ASC;
    public List<Producto> obtenerNombre(){
        List<Producto> productos=obtenerTodosLosProductos();
        List<Producto> resultado= productos.stream()
                .sorted(Comparator.comparing(Producto::getNombreProducto))
              .collect(Collectors.toList());
        return resultado;
    }


        //SELECT * FROM products ORDER BY category_id ASC,unit_price DESC;

    public List<Producto> obtenerCategoria(){
        List<Producto> productos=obtenerTodosLosProductos();
        List<Producto> resultado= productos.stream()
              .sorted(Comparator.comparing(Producto::getIdCategoria)
                      .thenComparing(Comparator.comparing(Producto::getPrecioUnitario).reversed()))
              .collect(Collectors.toList());
        return resultado;
    }
    //SELECT product_id,product_name,category_id,supplier_id
    //FROM products WHERE unit_price BETWEEN 25 AND 200 ORDER BY category_id, supplier_id;
    public List<String> obtenerprecioProductos() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<String> resultado= productos.stream()
                .sorted(Comparator.comparing(Producto::getIdCategoria)
                        .thenComparing(Comparator.comparing(Producto::getIdSupplier)))
              .filter(producto->producto.getPrecioUnitario()>=25 && producto.getPrecioUnitario() <=200)
              .map(producto->"Idprodcuto "+producto.getIdProductos()+
                        " nombre producto "+producto.getNombreProducto()+
                        " precio unitario "+producto.getPrecioUnitario())
              .collect(Collectors.toList());
        return resultado;
    }

    //SELECT count (product_id) FROM products;

    public long obtenerCantidadProductos() {
        List<Producto> productos=obtenerTodosLosProductos();
        long resultado= productos.stream().count();
        return resultado;
    }

    //SELECT sum(units_in_stock) FROM products;"

    public long obtenerCantidadInventarioProductos() {
        List<Producto> productos=obtenerTodosLosProductos();
        long resultado= productos.stream().mapToLong(Producto::getUnidadesEnStock).sum();
        return resultado;
    }

    //SELECT avg(unit_price) FROM products;

    public double obtenerPromedioInventarioProductos() {
        List<Producto> productos=obtenerTodosLosProductos();
        double resultado= productos.stream().mapToDouble(Producto::getPrecioUnitario).average().orElse(0);
        return resultado;
    }

    //--Obtener los datos de productos ordenados descendentemente por precio unitario de la categoría 1
    //SELECT * FROM products WHERE category_id =1 ORDER BY unit_price DESC;

    public List<Producto> obtenerProductosCategoria1() {
        List<Producto> productos=obtenerTodosLosProductos();
        List<Producto> resultado= productos.stream()
              .filter(producto->producto.getIdCategoria()==1)
              .sorted(Comparator.comparing(Producto::getPrecioUnitario).reversed())
              .collect(Collectors.toList());
        return resultado;
    }

    //SELECT * FROM  products WHERE unit_price BETWEEN 30 and 60 ORDER BY product_name;

    public List<Producto> obtenerPrecioentre(){
        List<Producto> productos=obtenerTodosLosProductos();
        List<Producto> resultado= productos.stream()
               .filter(producto->producto.getPrecioUnitario()>=30 && producto.getPrecioUnitario() <=60)
                   .sorted(Comparator.comparing(Producto::getNombreProducto))
             .collect(Collectors.toList());
        return resultado;
    }

    //OBTENER EL MAXIMO, MINIMO Y PROMEDIO DE PRECIO UNITARIO DE LA TABLA DE PRODUCTOS UTILIZANDO ALIAS

    public List<String> obtenerMaxMinPrecio(){
        List<Producto> producto = obtenerTodosLosProductos();

        OptionalDouble maxPrice = producto.stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .max();

        OptionalDouble minPrice = producto.stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .min();

        OptionalDouble avgPrice = producto.stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .average();

        double max = maxPrice.orElse(0.0);
        double min = minPrice.orElse(0.0);
        double avg = avgPrice.orElse(0.0);


        List<String> resultado= new ArrayList<>();
        resultado.add("Max "+max);
        resultado.add("Min "+min);
        resultado.add("Promedio "+avg);

        return resultado;
    }

    //SELECT count(*) as num_productos FROM products GROUP BY category_id;

    public Map<Short, Long> obtenerNumProductos() {
        List<Producto> producto = obtenerTodosLosProductos();
        Map<Short, Long> respuesta= producto.stream()
                .collect(Collectors.groupingBy(Producto::getIdCategoria, Collectors.counting()));

        respuesta.forEach((IdCategoria,count) -> System.out.println("Id categoria "+IdCategoria + " Cantidad " + count));
        return respuesta;
    }

    // SELECT avg(unit_price) as precio_promedio FROM products GROUP BY supplier_id;

    public Map<Short, Double> obtenerPrecioPromedioPorSupplier() {
        List<Producto> producto = obtenerTodosLosProductos();
        Map<Short, Double> respuesta= producto.stream()
                .collect(Collectors.groupingBy(Producto::getIdSupplier,
                        Collectors.averagingDouble(Producto::getPrecioUnitario)));
        respuesta.forEach((IdSupplier,precio) -> System.out.println("Id supplier "+IdSupplier+" Precio promedio "+precio));
    return respuesta;
    }

    //SELECT sum(units_in_stock) as suma_inventario FROM products GROUP BY supplier_id;

    public Map<Short, Integer> obtenerSumaInventario() {
        List<Producto> producto = obtenerTodosLosProductos();
        Map<Short, Integer> resultado =  producto.stream()
                .collect(Collectors.groupingBy(Producto::getIdSupplier, Collectors.summingInt(Producto::getUnidadesEnStock)));

        resultado.forEach((supplierId, sum) ->
                System.out.println("supplier_id: " + supplierId + ", suma_inventario: " + sum));
        return resultado;
    }



}


