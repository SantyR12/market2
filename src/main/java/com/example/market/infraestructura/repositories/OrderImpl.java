package com.example.market.infraestructura.repositories;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.repository.IOrder;
import com.example.market.infraestructura.crud.ClienteRepository;
import com.example.market.infraestructura.crud.OrdenRepository;
import com.example.market.infraestructura.entity.Cliente;
import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.entity.OrdenItem;
import com.example.market.infraestructura.mapper.OrdenItemMapper;
import com.example.market.infraestructura.mapper.OrdenMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements IOrder {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private OrdenMapper ordenMapper;


    public List<OrderDTO> getAll() {
        List<Orden> ordenes = ordenRepository.findAll();
        return ordenMapper.toOrderDTO(ordenes);
    }


    public OrderDTO getById(Long id) {
        Orden orden = ordenRepository.findById(id).get();
        return ordenMapper.toOrderDTO(orden);
    }


    public OrderDTO save(OrderDTO orderDTO) {
        Orden orden = ordenMapper.toOrden(orderDTO);
        orden.setTotal(0.0);
        return ordenMapper.toOrderDTO(ordenRepository.save(orden));
    }

    public OrderDTO update(Long id, OrderDTO order) {
        Orden orden = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        Orden updatedOrden = ordenMapper.toOrden(order);
        orden.setFecha(updatedOrden.getFecha());
        orden.setEstado(updatedOrden.getEstado());
        return ordenMapper.toOrderDTO(ordenRepository.save(orden));

    }

    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }

    public List<OrderDTO> getByClienteId(Long clienteId) {
        List<Orden> ordenes = ordenRepository.findByClienteId(clienteId);
        return ordenMapper.toOrderDTO(ordenes);
    }
}
