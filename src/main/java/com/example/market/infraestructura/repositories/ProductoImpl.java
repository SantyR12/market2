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
    public Optional<ProductDTO> getById(Long id) {
        return productoRepository.findById(id).map(productoMapper::toProductoDTO);
    }
    public void create(ProductDTO productDTO) {
        Producto producto = productoMapper.toProducto(productDTO);
        productoRepository.save(producto);
    }
    public void update(ProductDTO productDTO) {
        if (productDTO.getId() == null) {
            throw new IllegalArgumentException("ID requerido para actualizar el producto.");
        }

        Producto productoExistente = productoRepository.findById(productDTO.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + productDTO.getId()));

        Producto productoActualizado = productoMapper.toProducto(productDTO);
        productoActualizado.setId(productoExistente.getId());

        productoRepository.save(productoActualizado);
    }
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }



}
