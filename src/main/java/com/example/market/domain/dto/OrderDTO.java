package com.example.market.domain.dto;


import com.example.market.infraestructura.entity.OrdenItem;


import java.util.List;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private String date;
    private Double total;
    private String status;
    private Set<OrderItemDTO> ordenItems;
    private ClientDTO cliente;
    private Set<PayDTO> pays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderItemDTO> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(Set<OrderItemDTO> ordenItems) {
        this.ordenItems = ordenItems;
    }

    public ClientDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClientDTO cliente) {
        this.cliente = cliente;
    }

    public Set<PayDTO> getPays() {
        return pays;
    }

    public void setPays(Set<PayDTO> pays) {
        this.pays = pays;
    }
}
