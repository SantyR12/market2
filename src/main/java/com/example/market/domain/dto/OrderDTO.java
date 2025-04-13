package com.example.market.domain.dto;


import com.example.market.infraestructura.entity.OrdenItem;


import java.util.List;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private String date;
    private Integer total;
    private String status;
    private List<OrderItemDTO> ordenItems;
    private ClientDTO cliente;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItemDTO> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(List<OrderItemDTO> ordenItems) {
        this.ordenItems = ordenItems;
    }

    public ClientDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClientDTO cliente) {
        this.cliente = cliente;
    }
}
