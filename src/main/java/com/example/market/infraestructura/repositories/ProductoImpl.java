package com.example.market.infraestructura.repositories;

import java.util.List;
import java.util.Optional;

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
    public ProductDTO getById(Long id) {
        Producto producto = productoRepository.findById(id).get();
        return productoMapper.toProductDTO((producto));
    }
    public ProductDTO create(ProductDTO product) {
        Producto producto = productoMapper.toProducto(product);
        return productoMapper.toProductDTO(productoRepository.save(producto));
    }
    public ProductDTO update(Long id,ProductDTO product) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto"));
        Producto productoUpdate = productoMapper.toProducto(product);
        producto.setNombre(productoUpdate.getNombre());
        producto.setDescripcion(productoUpdate.getDescripcion());
        producto.setPrecio(productoUpdate.getPrecio());
        producto.setStock(productoUpdate.getStock());
        return productoMapper.toProductDTO(productoRepository.save(producto));
    }
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }



}
