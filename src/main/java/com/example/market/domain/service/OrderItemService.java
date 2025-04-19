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


    public List<OrderItemDTO> getAll(Long orderId) {
        return ordenItemImpl.getAll(orderId);
    }

    public OrderItemDTO save(Long orderId, OrderItemDTO orderItem) {
        return ordenItemImpl.crearOrdenItem(orderId,orderItem);
    }


    public OrderItemDTO update(Long id, Long OrderItemDTOId, OrderItemDTO ordenItem) {
        return ordenItemImpl.updateOrdenItemPor(id, OrderItemDTOId, ordenItem);
    }

    public void delete(Long id, Long OrderItemDTOId) {
        ordenItemImpl.eliminarOrdenItem(id,OrderItemDTOId);
    }
}
