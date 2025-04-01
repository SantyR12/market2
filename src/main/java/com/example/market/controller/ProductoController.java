package com.example.market.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.ProductoDTO;
import com.example.market.infraestructura.crud.ProductoRepositorty;
import com.example.market.infraestructura.mapper.ProductoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/productos")
public class ProductoController {
        
    @Autowired
    private ProductoRepositorty productoRespository;

    @Autowired
    private ProductoMapper productoMapper;

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoRespository.findAll()
        .stream().map(productoMapper::toProductoDTO)
        .collect(Collectors.toList()); 
    }  
    @PostMapping
    public ProductoDTO crearProducto(@RequestBody ProductoDTO productoDTO) {
        return productoMapper.toProductoDTO(productoRespository.save(productoMapper.toProducto(productoDTO)));
        
    }
    
    
}
