package com.example.market.domain.repository;


import com.example.market.domain.dto.OrderDTO;

import java.util.List;

public interface IOrder {
    List<OrderDTO> getAll();
}
