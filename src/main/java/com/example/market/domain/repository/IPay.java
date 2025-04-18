package com.example.market.domain.repository;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.dto.PayDTO;

import java.util.List;

public interface IPay {
    
    List<PayDTO> getAll();

    PayDTO create(PayDTO payDTO);

    PayDTO update(PayDTO payDTO);

    void delete(Long id);

    List<PayDTO> getByOrdenId(Long ordenId);
    
}
