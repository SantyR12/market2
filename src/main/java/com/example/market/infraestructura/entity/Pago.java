package com.example.market.infraestructura.entity;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< Updated upstream
    private Integer fechaPago;
=======
    private String Fecha;
>>>>>>> Stashed changes
    private Double monto;
    private String metodo;
    private String estado;

    // Movido al final
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< Updated upstream
    public Integer getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Integer fechaPago) {
        this.fechaPago = fechaPago;
=======
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
>>>>>>> Stashed changes
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

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
