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
    @PostMapping
    public ResponseEntity<PayDTO> createPay(@RequestBody PayDTO payDTO) {
        PayDTO creado = payService.crearPago(payDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayDTO> updatePago(@PathVariable Long id, @RequestBody PayDTO payDTO) {
        payDTO.setId(id);
        PayDTO actualizado = payService.actualizarPago(payDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePago(@PathVariable Long id) {
        payService.eliminarPago(id);
        return new ResponseEntity<>("Pago eliminado exitosamente", HttpStatus.OK);
    }
    
    @GetMapping("/orden/{ordenId}")
    public List<PayDTO> getByOrdenId(@PathVariable Long ordenId) {
        return payService.getByOrdenId(ordenId);
    }
}
