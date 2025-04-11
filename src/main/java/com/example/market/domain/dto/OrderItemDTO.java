package com.example.market.domain.dto;

import com.example.market.infraestructura.entity.Orden;


import java.util.List;


public class OrderItemDTO {

    private long id;
    private Integer quantity;
    private Double unitPrice;

    private Orden orden;

    private ProductDTO producto;

    public ProductDTO getProducto() {
        return producto;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setProducto(ProductDTO producto) {
        this.producto = producto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
