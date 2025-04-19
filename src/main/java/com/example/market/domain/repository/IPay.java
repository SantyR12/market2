package com.example.market.domain.repository;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.dto.PayDTO;

import java.util.List;

public interface IPay {
    
    public List<PayDTO> getAll();

    public PayDTO obtenerPorId(Long id);

    public PayDTO create(PayDTO payDTO);

    public PayDTO update(Long id,PayDTO payDTO);

    public void delete(Long id);

    public List<PayDTO> getByOrdenId(Long ordenId);
    
}
