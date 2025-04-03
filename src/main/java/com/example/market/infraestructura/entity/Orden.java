package com.example.market.infraestructura.entity;
import java.util.List;

import jakarta.persistence.*;
@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer Fecha;
    private Integer total;
    private String  estado;

    @ManyToOne
    @JoinColumn(name= "id")
    private Cliente cliente;

    @OneToMany
    private List<Pago> pagos;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFecha() {
        return Fecha;
    }

    public void setFecha(Integer fecha) {
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
