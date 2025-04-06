package com.example.market.infraestructura.entity;

import jakarta.persistence.*;

@Entity
public class OrdenItem extends Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private Double precioUnitarios;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitarios() {
        return precioUnitarios;
    }

    public void setPrecioUnitarios(Double precioUnitarios) {
        this.precioUnitarios = precioUnitarios;
    }
}
