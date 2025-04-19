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
import java.util.Set;

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
    OrdenItem toOrdenItem(OrderItemDTO dto);
    List<OrdenItem> toOrdenItems(List<OrderItemDTO> orderItemDTO);



}
