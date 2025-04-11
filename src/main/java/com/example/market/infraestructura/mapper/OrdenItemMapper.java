package com.example.market.infraestructura.mapper;


import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.entity.OrdenItem;
import com.example.market.infraestructura.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdenItemMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "precioUnitario", target = "unitPrice"),
            @Mapping(source = "producto", target = "producto"),
            @Mapping(source = "orden", target = "orden")
    })
    OrderItemDTO toOrdenItemDTO(OrdenItem ordenItem);

    List<OrderItemDTO> toOrdenItemsDTO(List<OrdenItem> ordenItems);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "orden", ignore = true)
    })
    OrdenItem toOrdenItem(OrderItemDTO dto);

    default OrdenItem toOrdenItem(OrderItemDTO dto, Producto producto, Orden orden) {
        OrdenItem item = toOrdenItem(dto);
        item.setProducto(producto);
        item.setOrden(orden);
        return item;
    }
}
