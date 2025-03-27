package com.example.market;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/productos")
public class ProdutoController {
        
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
}
