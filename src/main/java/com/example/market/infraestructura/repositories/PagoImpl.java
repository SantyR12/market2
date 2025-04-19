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
    private PagoRepository pagoRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public List<PayDTO> getAll() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagoMapper.toPaymentsDTO(pagos);
    }
    @Override
    public PayDTO obtenerPorId(Long id) {
        Pago pago = pagoRepository.findById(id).get();
        return pagoMapper.toPayDTO(pago);
    }
    @Override
    public PayDTO create(PayDTO payDTO) {
        Pago pago = pagoMapper.toPago(payDTO);
        return pagoMapper.toPayDTO(pagoRepository.save(pago));
    }

    @Override
    public PayDTO update(Long id,PayDTO payDTO) {
        Pago pago = pagoRepository.findById(id).orElseThrow(()-> new RuntimeException("no existe el pago con el id:"));
        Pago pagoUpdate = pagoMapper.toPago(payDTO);
        pago.setFecha(pagoUpdate.getFecha());
        pago.setMonto(pagoUpdate.getMonto());
        pago.setMetodo(pagoUpdate.getMetodo());
        pago.setEstado(pagoUpdate.getEstado());
        return pagoMapper.toPayDTO(pagoRepository.save(pago));

    }
    @Override
    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
    @Override
    public List<PayDTO> getByOrdenId(Long ordenId) {
        List<Pago> pagos = pagoRepository.findByOrdenId(ordenId);
        return pagoMapper.toPaymentsDTO((pagos));
    }

    
}
