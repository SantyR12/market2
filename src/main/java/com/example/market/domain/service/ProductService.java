package com.example.market.domain.service;

import java.util.List;

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
    public void crearProducto(ProductDTO productDTO) {
        productoImpl.create(productDTO);
    }
} 