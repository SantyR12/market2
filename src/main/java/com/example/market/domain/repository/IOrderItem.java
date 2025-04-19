package com.example.market.domain.repository;


import com.example.market.domain.dto.OrderItemDTO;

import java.util.List;

public interface IOrderItem {
    List<OrderItemDTO> getAll(Long id);
    OrderItemDTO crearOrdenItem(Long orderId, OrderItemDTO order);
    OrderItemDTO updateOrdenItemPor(Long id, Long orderItemId, OrderItemDTO order);
    void eliminarOrdenItem(Long id, Long orderItemId);
}
