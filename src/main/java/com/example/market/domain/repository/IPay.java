package com.example.market.domain.repository;


import com.example.market.domain.dto.PayDTO;

import java.util.List;

public interface IPay {
    List<PayDTO> getAll();
}
