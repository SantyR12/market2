package com.example.market.controller;


import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.domain.service.OrderItemService;
import com.example.market.infraestructura.entity.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> obtenerItemsPorOrden(@PathVariable Long ordenId) {
        List<OrderItemDTO> items = orderItemService.obtenerItemsPorOrden(ordenId);
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> crearItem(@PathVariable Long ordenId, @RequestBody OrderItemDTO dto) {
        Orden orden = new Orden();
        orden.setId(ordenId);
        dto.setOrden(orden);
        return ResponseEntity.ok(orderItemService.crearOrdenItem(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> actualizarItem(
            @PathVariable Long ordenId,
            @PathVariable Long id,
            @RequestBody OrderItemDTO dto
    ) {
        Orden orden = new Orden();
        orden.setId(ordenId);
        dto.setOrden(orden);
        dto.setId(id);
        return ResponseEntity.ok(orderItemService.crearOrdenItem(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        orderItemService.eliminarOrdenItem(id);
        return ResponseEntity.noContent().build();
    }
}
