package com.example.market.domain.repository;

import com.example.market.domain.dto.ProductDTO;

import java.util.List;

public interface IProduct {
    
    List<ProductDTO> getAll();
    void create(ProductDTO productDTO);

 
    
}
