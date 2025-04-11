package com.example.market.domain.service;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructura.repositories.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    private OrderImpl orderImpl;

    public List<OrderDTO> getAll() {

        return orderImpl.getAll();
    }

    public OrderDTO getById(Long id) {

        return orderImpl.getById(id);
    }

    public void save(OrderDTO orderDTO) {

        orderImpl.save(orderDTO);
    }

    public void update(Long id, OrderDTO orderDTO) {

        orderImpl.update(id, orderDTO);
    }

    public void delete(Long id) {
        orderImpl.delete(id);
    }

    public List<OrderDTO> getByClienteId(Long clienteId) {

        return orderImpl.getByClienteId(clienteId);
    }

}
