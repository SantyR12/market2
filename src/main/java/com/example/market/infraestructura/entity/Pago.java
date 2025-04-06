package com.example.market.infraestructura.entity;

import jakarta.persistence.*;


@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fechaPago;
    private Double monto;
    private String metodo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Integer fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
