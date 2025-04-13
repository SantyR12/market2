package com.example.market.infraestructura.mapper;

import java.util.List;

import com.example.market.domain.dto.PayDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.infraestructura.entity.Pago;

@Mapper(componentModel = "spring", uses = {OrdenMapper.class})
public interface PagoMapper {
    

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "date", source = "fecha"),
            @Mapping(target = "amount", source = "monto"),
            @Mapping(target = "method", source = "metodo"),
            @Mapping(target = "status", source = "estado"),
            @Mapping(target = "orden", source = "orden")
    })
    PayDTO toPagoDTO(Pago pago);
    
    List<PayDTO> toPagosDTO(List<Pago> pagos);
    
    @InheritInverseConfiguration
    Pago toPago(PayDTO pagoDTO);
    List<Pago> toPagos(List<PayDTO> pagossDTO);

    
}