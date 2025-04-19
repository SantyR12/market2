package com.example.market.controller;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrderItemController {


    @Autowired
    private OrderItemService orderItemService;


    @GetMapping
    public List<OrderItemDTO> obtenerItemsPorOrden(@PathVariable Long ordenId) {
        return orderItemService.getAll(ordenId);
    }

    @PostMapping
    public OrderItemDTO crearItem(@PathVariable Long ordenId, @RequestBody OrderItemDTO ordenItemDTO) {
        return orderItemService.save(ordenId, ordenItemDTO);
    }

    @PutMapping("/{id}")
    public OrderItemDTO actualizarItem(@PathVariable Long ordenId, @PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.update(ordenId, id, orderItemDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarItem(@PathVariable Long id, @PathVariable Long ordenId) {
       orderItemService.delete(ordenId, id);
    }
}
