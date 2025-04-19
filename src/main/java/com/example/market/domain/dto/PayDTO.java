package com.example.market.domain.dto;

public class PayDTO {
    private Long id;
    private String date;
    private Double amount;
    private String method;
    private String status;
    private OrderDTO orden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderDTO getOrden() {
        return orden;
    }

    public void setOrden(OrderDTO orden) {
        this.orden = orden;
    }

    
}
