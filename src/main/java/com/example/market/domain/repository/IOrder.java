package com.example.market.domain.repository;


import com.example.market.domain.dto.OrderDTO;

import java.util.List;

public interface IOrder {
    List<OrderDTO> getAll();

    void create(OrderDTO order);
    void update(OrderDTO order);
    void delete(OrderDTO order);

}
