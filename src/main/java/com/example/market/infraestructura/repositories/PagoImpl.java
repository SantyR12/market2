package com.example.market.infraestructura.repositories;

import java.util.List;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.dto.PayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.repository.IPay;
import com.example.market.infraestructura.crud.OrdenRepository;
import com.example.market.infraestructura.crud.PagoRepository;
import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.entity.Pago;
import com.example.market.infraestructura.mapper.PagoMapper;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PagoImpl implements IPay  {

    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    private PagoRepository pagoRepository;


    @Autowired
    private PagoMapper pagoMapper;

    public List<PayDTO> getAll() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagoMapper.toPagosDTO(pagos);
    }
    public PayDTO create(PayDTO payDTO) {
        Pago pago = pagoMapper.toPago(payDTO);
        Pago guardado = pagoRepository.save(pago);
        return pagoMapper.toPagoDTO(guardado);
    }
    
    public PayDTO update(PayDTO payDTO) {
        if (payDTO.getId() == null) {
            throw new IllegalArgumentException("ID requerido para actualizar el pago.");
        }
    
        Pago pagoExistente = pagoRepository.findById(payDTO.getId())
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + payDTO.getId()));
    
        Pago pagoActualizado = pagoMapper.toPago(payDTO);
        pagoActualizado.setId(pagoExistente.getId());
    
        Pago guardado = pagoRepository.save(pagoActualizado);
        return pagoMapper.toPagoDTO(guardado);
    }
    
    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }

    public List<PayDTO> getByOrdenId(Long ordenId) {
        List<Pago> pagos = pagoRepository.findByOrdenId(ordenId);
        return pagoMapper.toPagosDTO(pagos);
    }

    
}
