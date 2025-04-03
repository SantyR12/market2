package com.example.market.infraestructura.mapper;

import java.util.List;

import com.example.market.domain.dto.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.infraestructura.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "nombre"),
            @Mapping(target = "description", source = "descripcion"),
            @Mapping(target = "price", source = "precio")
    })
    ProductDTO toProductoDTO(Producto producto);
    
    List<ProductDTO> toProductosDTO(List<Producto> productos);
    
    @InheritInverseConfiguration
    Producto toProducto(ProductDTO productoDTO);
    List<Producto> toProductos(List<ProductDTO> productosDTO);

    
}