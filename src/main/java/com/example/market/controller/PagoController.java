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
    public ResponseEntity<String> createPay(@RequestBody PayDTO payDTO) {
        payService.crearPago(payDTO);
        return new ResponseEntity<>("Pago registrado exitosamente", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePago(@PathVariable Long id,@RequestBody PayDTO payDTO) {
        payDTO.setId(id);
        payService.actualizarPago(payDTO);
        return new ResponseEntity<>("Pago modificado exitosamente", HttpStatus.OK);
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
