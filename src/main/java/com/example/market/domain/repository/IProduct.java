package com.example.market.domain.repository;

import com.example.market.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    
    public List<ProductDTO> getAll();

    public ProductDTO getById(Long id);

    public ProductDTO create(ProductDTO product);

    public ProductDTO update(Long id, ProductDTO productDTO);

    public void delete(Long id);

 
    
}
