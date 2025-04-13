package com.example.market.controller;


import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.domain.service.OrderItemService;
import com.example.market.domain.service.OrderService;
import com.example.market.infraestructura.crud.OrderItemRepository;
import com.example.market.infraestructura.crud.ProductoRepository;
import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.entity.OrdenItem;
import com.example.market.infraestructura.entity.Producto;
import com.example.market.infraestructura.mapper.OrdenItemMapper;
import com.example.market.infraestructura.mapper.OrdenMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final OrderService orderService;
    private final OrderItemRepository orderItemRepository;
    private final ProductoRepository productoRepository;
    private final OrdenItemMapper ordenItemMapper;
    private final OrdenMapper ordenMapper;

    @Autowired
    public OrderItemController(OrderItemService orderItemService,
                               OrderService orderService,
                               OrderItemRepository orderItemRepository,
                               ProductoRepository productoRepository,
                               OrdenItemMapper ordenItemMapper,
                               OrdenMapper ordenMapper) {
        this.orderItemService = orderItemService;
        this.orderService = orderService;
        this.orderItemRepository = orderItemRepository;
        this.productoRepository = productoRepository;
        this.ordenItemMapper = ordenItemMapper;
        this.ordenMapper = ordenMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> obtenerItemsPorOrden(@PathVariable Long ordenId) {
        List<OrderItemDTO> items = orderItemService.obtenerItemsPorOrden(ordenId);
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> crearItem(@PathVariable Long ordenId, @RequestBody OrderItemDTO dto) {
        OrderDTO orderDTO = orderService.getById(ordenId);
        if (orderDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Producto producto = productoRepository.findById(dto.getProducto().getId())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        OrdenItem ordenItem = new OrdenItem();
        ordenItem.setCantidad(dto.getQuantity());
        ordenItem.setPrecioUnitario(dto.getUnitPrice());
        ordenItem.setProducto(producto);
        ordenItem.setOrden(ordenMapper.toOrden(orderDTO));

        orderItemRepository.save(ordenItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenItemMapper.toOrdenItemDTO(ordenItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> actualizarItem(@PathVariable Long ordenId, @PathVariable Long id, @RequestBody OrderItemDTO dto) {
        Orden orden = new Orden();
        orden.setId(ordenId);
        dto.setOrden(orden);

        try {
            OrderItemDTO updatedItem = orderItemService.actualizarOrdenItem(id, dto);
            return ResponseEntity.ok(updatedItem);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        try {
            orderItemService.eliminarOrdenItem(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
