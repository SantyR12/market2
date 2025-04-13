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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements IOrder {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private OrdenItemMapper ordenItemMapper;
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
    public void update(Long id, OrderDTO dto) {
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));


        orden.setFecha(dto.getDate());
        orden.setTotal(dto.getTotal());
        orden.setEstado(dto.getStatus());


        Cliente clienteExistente = clienteRepository.findById(dto.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombre(dto.getCliente().getName());
        clienteExistente.setEmail(dto.getCliente().getEmail());
        clienteExistente.setDireccion(dto.getCliente().getDirection());
        clienteExistente.setTelefono(dto.getCliente().getPhone());

        clienteRepository.save(clienteExistente);
        orden.setCliente(clienteExistente);

        List<OrdenItem> nuevosItems = dto.getOrdenItems().stream()
                .map(itemDTO -> {
                    OrdenItem item = ordenItemMapper.toOrdenItem(itemDTO);
                    item.setOrden(orden);
                    return item;
                })
                .toList();

        orden.getOrdenItems().clear();
        orden.getOrdenItems().addAll(nuevosItems);


        ordenRepository.save(orden);
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
