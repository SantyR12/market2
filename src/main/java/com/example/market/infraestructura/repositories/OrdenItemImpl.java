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

import java.util.List;
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

    public OrderItemDTO crearOrdenItem(OrderItemDTO dto) {

        Producto producto = productoRepository.findById(dto.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("No existe el producto"));

        Orden orden  = ordenRepository.findById(dto.getOrden().getId())
                .orElseThrow(() -> new  RuntimeException("orden no encontrada"));

        OrdenItem entity = new OrdenItem();
        entity.setProducto(producto);
        entity.setOrden(orden);
        entity.setCantidad(dto.getQuantity());
        entity.setPrecioUnitario(dto.getUnitPrice());

        // Guardar el item en la base de datos
        OrdenItem saved = orderItemRepository.save(entity);

        // Convertir la entidad guardada a un DTO para devolverlo
        return ordenItemMapper.toOrdenItemDTO(saved);
    }

    public OrderItemDTO obtenerOrdenItemPorId(Long id) {
        return orderItemRepository.findById(id)
                .map(ordenItemMapper::toOrdenItemDTO)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
    }

    public List<OrderItemDTO> obtenerItemsPorOrden(Long ordenId) {
        return orderItemRepository.findByOrden_Id(ordenId)
                .stream()
                .map(ordenItemMapper::toOrdenItemDTO)
                .collect(Collectors.toList());
    }

    public void eliminarOrdenItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    public List<OrderItemDTO> getAll() {
        return ordenItemMapper.toOrdenItemsDTO(orderItemRepository.findAll());
    }

    public OrderItemDTO actualizarOrdenItem(Long id, OrderItemDTO dto) {
        OrdenItem ordenItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));

        Producto producto = productoRepository.findById(dto.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Orden orden = ordenRepository.findById(dto.getOrden().getId())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        ordenItem.setCantidad(dto.getQuantity());
        ordenItem.setPrecioUnitario(dto.getUnitPrice());
        ordenItem.setProducto(producto);
        ordenItem.setOrden(orden);

        OrdenItem updated = orderItemRepository.save(ordenItem);
        return ordenItemMapper.toOrdenItemDTO(updated);
    }


}
