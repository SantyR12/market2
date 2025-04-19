package com.example.market.controller;

import java.util.List;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.dto.PayDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.service.PayService;


@RestController
@RequestMapping("/pagos")
public class PagoController {
    
    @Autowired
    private PayService payService;

    @GetMapping
    public List<PayDTO> obtenerPagos() {

        return payService.obtenerTodo();
    }
    @GetMapping("/{id}")
    public PayDTO obtenerPorId(@PathVariable Long id) {
        return payService.obtenerPorId(id);

    }
    @PostMapping
    public PayDTO createPay(@RequestBody PayDTO payDTO) {
        return payService.crearPago(payDTO);
    }
    @PutMapping("/{id}")
    public PayDTO updatePago(@PathVariable Long id,@RequestBody PayDTO payDTO) {
        return payService.actualizarPago(id, payDTO);
    }
    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Long id) {
        payService.eliminarPago(id);
    }
    
    @GetMapping("/orden/{ordenId}")
    public List<PayDTO> getByOrdenId(@PathVariable Long ordenId) {
        return payService.getByOrdenId(ordenId);
    }
}
