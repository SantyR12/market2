package com.example.market.controller;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
        OrderDTO order = orderService.getById(id);
        return (order != null) ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrder = orderService.save(orderDTO);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.update(id, orderDTO);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/cliente/{clienteId}")
    public List<OrderDTO> getByClienteId(@PathVariable Long clienteId) {
        return orderService.getByClienteId(clienteId);
    }
}
