package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructura.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.infraestructura.repositories.ProductoImpl;

@Service
public class ProductService {
    
    @Autowired
    private ProductoImpl productoImpl;

    public List<ProductDTO> obtenerTodo() {
        return productoImpl.getAll();
    }
    public ProductDTO obtenerProductoPorId(Long id) {
        return productoImpl.getById(id);
    }

    public ProductDTO crearProducto(ProductDTO productDTO) {
        return productoImpl.create(productDTO);
    }
    public ProductDTO actualizarProducto(Long id,ProductDTO productDTO) {
        return productoImpl.update(id,productDTO);
    }
    public void eliminarProducto(Long id) {
        productoImpl.delete(id);
    }
} 