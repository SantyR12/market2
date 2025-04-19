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
    @GetMapping("/{id}")
    public ProductDTO obtenerProductoPorId(@PathVariable Long id) {
        return productService.obtenerProductoPorId(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO entity) {
        return productService.crearProducto(entity);


    }
    @PutMapping("/{id}")
    public ProductDTO updateProducto(@PathVariable Long id,@RequestBody ProductDTO entity) {
        return productService.actualizarProducto(id,entity);
    }
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productService.eliminarProducto(id);

    }
    
    
    
    
    
}
