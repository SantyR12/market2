package com.example.market.domain.dto;

import com.example.market.infraestructura.entity.Orden;


public class OrderItemDTO {

    private long id;
    private Integer quantity;
    private Double unitPrice;
    private OrderDTO orden;
    private ProductDTO producto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDTO getOrden() {
        return orden;
    }

    public void setOrden(OrderDTO orden) {
        this.orden = orden;
    }

    public ProductDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductDTO producto) {
        this.producto = producto;
    }
}
