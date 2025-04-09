package com.example.market.domain.dto;

import com.example.market.infraestructura.entity.Orden;

public class OrderItemDTO {

    private long id;
    private Integer quantity;
    private Double unitPrice;
    private Orden orden;

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
