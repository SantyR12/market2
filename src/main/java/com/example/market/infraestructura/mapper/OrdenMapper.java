package com.example.market.infraestructura.mapper;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructura.entity.Orden;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface OrdenMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "date", source = "fecha"),
            @Mapping(target = "total", source = "total"),
            @Mapping(target = "status", source = "estado"),
            @Mapping(target = "cliente", source = "cliente"),  // Asegúrate de que 'cliente' esté en la entidad Orden
            @Mapping(target = "ordenItems", source = "ordenItems", ignore = true)  // Asegúrate de que 'ordenItems' esté en la entidad Orden
    })

    OrderDTO toOrderDTO(Orden orden);

    List<OrderDTO> toOrderDTO(List<Orden> ordenes);

    @InheritInverseConfiguration
    @Mapping(target = "ordenItems", ignore = true)
    Orden toOrden(OrderDTO ordenDTO);
    List<Orden> toOrdenes(List<OrderDTO> ordenes);
}