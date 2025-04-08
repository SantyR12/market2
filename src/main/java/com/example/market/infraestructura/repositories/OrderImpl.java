package com.example.market.infraestructura.repositories;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.repository.IOrder;
import com.example.market.infraestructura.crud.OrdenRepository;
import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.mapper.OrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements IOrder {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    @Override
    public List<OrderDTO> getAll() {
        return ordenMapper.toOrderDTO(ordenRepository.findAll());
    }

    @Override
    public OrderDTO getById(Long id) {
        return ordenRepository.findById(id)
                .map(ordenMapper::toOrderDTO)
                .orElse(null);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        Orden orden = ordenMapper.toOrden(orderDTO);
        ordenRepository.save(orden);
    }

    @Override
    public void update(Long id, OrderDTO orderDTO) {
        if (ordenRepository.existsById(id)) {
            Orden orden = ordenMapper.toOrden(orderDTO);
            orden.setId(id);
            ordenRepository.save(orden);
        }
    }

    @Override
    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getByClienteId(Long clienteId) {
        List<Orden> ordenes = ordenRepository.findByClienteId(clienteId);
        return ordenMapper.toOrderDTO(ordenes);
    }
}
