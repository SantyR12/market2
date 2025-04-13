package com.example.market.domain.service;

import java.util.List;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.dto.PayDTO;
import com.example.market.infraestructura.entity.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.infraestructura.repositories.PagoImpl;

@Service
public class PayService {
    
    @Autowired
    private PagoImpl pagoImpl;

    public List<PayDTO> obtenerTodo() {
        return pagoImpl.getAll();
    }
    public void crearPago(PayDTO payDTO) {
        pagoImpl.create(payDTO);
    }
    public void actualizarPago(PayDTO payDTO) {
        pagoImpl.update(payDTO);
    }
    public void eliminarPago(Long id) {
        pagoImpl.delete(id);
    }

    public List<PayDTO> getByOrdenId(Long ordenId) {

        return pagoImpl.getByOrdenId(ordenId);
    }
} 