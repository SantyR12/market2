package com.example.market.infraestructura.repositories;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.infraestructura.crud.OrdenRepository;
import com.example.market.infraestructura.crud.OrderItemRepository;
import com.example.market.infraestructura.crud.ProductoRepository;
import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.entity.OrdenItem;
import com.example.market.infraestructura.entity.Producto;
import com.example.market.infraestructura.mapper.OrdenItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrdenItemImpl implements IOrderItem {

    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private OrdenItemMapper ordenItemMapper;

    public List<OrderItemDTO> getAll(Long id) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el orden"));
        Set<OrdenItem> ordenItems = orden.getOrdenItems();
        List<OrdenItem> orderItems = new ArrayList<>(ordenItems);
        return ordenItemMapper.toOrdenItemsDTO(orderItems);
    }

    public OrderItemDTO crearOrdenItem(Long id,OrderItemDTO orderItemDTO) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el orden"));
        Producto producto = productoRepository.findById(orderItemDTO.getProducto().getId()).orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        OrdenItem ordenItem = ordenItemMapper.toOrdenItem(orderItemDTO);
        double total = orden.getTotal();
        ordenItem.setOrden(orden);
        ordenItem.setProducto(producto);
        ordenItem.setPrecioUnitario(producto.getPrecio());
        total += ordenItem.getPrecioUnitario() * producto.getPrecio();
        orden.setTotal(total);
        ordenRepository.save(orden);
        return ordenItemMapper.toOrdenItemDTO(orderItemRepository.save(ordenItem));
    }


    public void eliminarOrdenItem(Long id, Long ordenItemId) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el orden"));
        OrdenItem ordenItem = orderItemRepository.findById(ordenItemId).orElseThrow(()->new RuntimeException("No se encontro el ordenItem"));
        double total = orden.getTotal();
        if (!ordenItem.getOrden().getId().equals(orden.getId())) {
            throw new RuntimeException("El orden item no tiene un orden");
        }
        total -= ordenItem.getPrecioUnitario() * ordenItem.getCantidad();
        orden.setTotal(total);
        ordenRepository.save(orden);
        orderItemRepository.deleteById(ordenItemId);

    }
    public OrderItemDTO updateOrdenItemPor(Long id, Long orderItemId, OrderItemDTO dto) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el orden"));
        OrdenItem ordenItemToUpdate = orderItemRepository.findById(orderItemId).orElseThrow(()->new RuntimeException("No se encontro el ordenItem"));
        OrdenItem updateOrdenItem = ordenItemMapper.toOrdenItem(dto);
        Producto producto = productoRepository.findById(updateOrdenItem.getProducto().getId()).orElseThrow(()->new RuntimeException("Producto no encontrado"));
        double total = orden.getTotal();
        if (!ordenItemToUpdate.getProducto().getId().equals(orden.getId())) {
            throw new RuntimeException("El orden no pertenece a la orden ");
        }
        total -= ordenItemToUpdate.getPrecioUnitario() * ordenItemToUpdate.getCantidad();
        ordenItemToUpdate.setCantidad(updateOrdenItem.getCantidad());
        ordenItemToUpdate.setPrecioUnitario(producto.getPrecio());
        ordenItemToUpdate.setProducto(updateOrdenItem.getProducto());
        ordenItemToUpdate.setOrden(orden);
        total += ordenItemToUpdate.getPrecioUnitario() * producto.getPrecio();
        orden.setTotal(total);
        ordenRepository.save(orden);
        return ordenItemMapper.toOrdenItemDTO(orderItemRepository.save(ordenItemToUpdate));


    }


}
