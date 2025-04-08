package com.example.market.infraestructura.mapper;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructura.entity.Orden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "date", source = "fecha"),
            @Mapping(target = "total", source = "total"),
            @Mapping(target = "status", source = "estado")
    })
    OrderDTO toOrderDTO(Orden orden);

    List<OrderDTO> toOrderDTO(List<Orden> ordenes);

    @InheritInverseConfiguration
    Orden toOrden(OrderDTO ordenDTO);
    List<Orden> toOrdenes(List<OrderDTO> ordenes);

}
