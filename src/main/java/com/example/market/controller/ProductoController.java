package com.example.market.controller;

import java.util.List;

import com.example.market.domain.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.service.ProductService;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> obtenerProductos() {

        return productService.obtenerTodo();
    }
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        productService.crearProducto(productDTO);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }
    
    
    
    
    
}
