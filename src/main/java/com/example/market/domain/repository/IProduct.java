package com.example.market.domain.repository;

import com.example.market.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    
    List<ProductDTO> getAll();

    Optional<ProductDTO> getById(Long id);

    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);

    void delete(Long id);

 
    
}
