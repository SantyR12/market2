package com.example.market.infraestructura.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.ProductoDTO;
import com.example.market.infraestructura.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "nombre"),
            @Mapping(target = "description", source = "descripcion"),
            @Mapping(target = "price", source = "precio")
    })
    ProductoDTO toProductoDTO(Producto producto);
    
    List<ProductoDTO> toProductosDTO(List<Producto> productos);
    
    @InheritInverseConfiguration
    Producto toProducto(ProductoDTO productoDTO);
    List<Producto> toProductos(List<ProductoDTO> productosDTO);

    
}