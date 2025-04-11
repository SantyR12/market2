package com.example.market.domain.repository;


import com.example.market.domain.dto.OrderItemDTO;

import java.util.List;

public interface IOrderItem {
    List<OrderItemDTO> getAll();
    OrderItemDTO crearOrdenItem(OrderItemDTO dto);
    OrderItemDTO obtenerOrdenItemPorId(Long id);
    List<OrderItemDTO> obtenerItemsPorOrden(Long ordenId);
    void eliminarOrdenItem(Long id);
}
