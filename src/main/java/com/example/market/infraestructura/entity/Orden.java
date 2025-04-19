package com.example.market.infraestructura.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private Double total;
    private String  estado;

    @OneToMany(mappedBy = "orden")
    private Set<OrdenItem> ordenItems;

    @ManyToOne
    @JoinColumn(name= "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "orden")
    private Set<Pago> pagos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<OrdenItem> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(Set<OrdenItem> ordenItems) {
        this.ordenItems = ordenItems;
    }

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
