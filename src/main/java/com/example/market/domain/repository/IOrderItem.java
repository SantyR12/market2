package com.example.market.domain.repository;


import com.example.market.domain.dto.OrderItemDTO;

import java.util.List;

public interface IOrderItem {
    List<OrderItemDTO> getAll();
}
