package com.softtek.proyecto2305.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private Short idSupplier;
    private Double precioPromedio;
    private Integer sumainventario;


}
