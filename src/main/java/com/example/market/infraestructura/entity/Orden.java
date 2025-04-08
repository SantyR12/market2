package com.example.market.infraestructura.entity;
import java.util.List;

import jakarta.persistence.*;
@Entity

public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Fecha;
    private Integer total;
    private String  estado;

    @ManyToOne
    @JoinColumn(name= "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "orden")
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
