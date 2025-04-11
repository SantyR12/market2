package com.example.market.domain.service;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructura.repositories.OrdenItemImpl;
import com.example.market.infraestructura.repositories.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrdenItemImpl ordenItemImpl;


    public OrderItemDTO crearOrdenItem(OrderItemDTO dto) {
        return ordenItemImpl.crearOrdenItem(dto);
    }


    public OrderItemDTO obtenerOrdenItemPorId(Long id) {
        return ordenItemImpl.obtenerOrdenItemPorId(id);
    }


    public List<OrderItemDTO> obtenerItemsPorOrden(Long ordenId) {
        return ordenItemImpl.obtenerItemsPorOrden(ordenId);
    }


    public void eliminarOrdenItem(Long id) {
        ordenItemImpl.eliminarOrdenItem(id);
    }


    public List<OrderItemDTO> getAll() {
        return ordenItemImpl.getAll();
    }
}
