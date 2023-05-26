package com.softtek.proyecto2305.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Cliente {

    @Id
    @Column(name = "customer_id")
    private String idCliente;
    @Column(name="company_name")
    private String nombreCompania;
    @Column(name="contact_name")
    private String nombreContacto;
    @Column(name="contact_title")
    private String email;
    @Column(name="address")
    private String direccion;
    @Column(name="city")
    private String ciudad;
    @Column(name="region")
    private String region;
    @Column(name="postal_code")
    private String codigoPostal;
    @Column(name="country")
    private String pais;
    @Column(name="phone")
    private String telefono;
    @Column(name="fax")
    private String fax;


}
