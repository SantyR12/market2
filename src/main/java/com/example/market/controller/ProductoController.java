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
    public ResponseEntity<ProductDTO> obtenerProductoPorId(@PathVariable Long id) {
        return productService.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO creado = productService.crearProducto(productDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProducto(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        ProductDTO actualizado = productService.actualizarProducto(productDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        productService.eliminarProducto(id);
        return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
    }
    
    
    
    
    
}
