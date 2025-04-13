package com.example.market.infraestructura.entity;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
@Entity

public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Fecha;
    private Integer total;
    private String  estado;
    @JsonManagedReference
    @OneToMany(mappedBy = "orden")
    private List<OrdenItem> ordenItems;

    @ManyToOne
    @JoinColumn(name= "cliente_id")
    private Cliente cliente;


    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL )
    private List<Pago> pagos;



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public List<OrdenItem> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(List<OrdenItem> ordenItems) {
        this.ordenItems = ordenItems;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
