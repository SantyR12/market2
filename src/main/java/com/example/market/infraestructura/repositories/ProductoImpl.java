package com.example.market.infraestructura.repositories;

import java.util.List;

import com.example.market.domain.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.repository.IProduct;
import com.example.market.infraestructura.crud.ProductoRepository;
import com.example.market.infraestructura.entity.Producto;
import com.example.market.infraestructura.mapper.ProductoMapper;

@Service
public class ProductoImpl implements IProduct  {

    @Autowired
    private ProductoRepository productoRepository;


    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductDTO> getAll() {
        List<Producto> productos = productoRepository.findAll();
        return productoMapper.toProductosDTO(productos);
    }
    public void create(ProductDTO productDTO) {
        Producto producto = productoMapper.toProducto(productDTO);
        productoRepository.save(producto);
    }

    
}
