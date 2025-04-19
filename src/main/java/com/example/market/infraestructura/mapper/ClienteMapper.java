package com.example.market.infraestructura.mapper;

import com.example.market.domain.dto.ClientDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.infraestructura.entity.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "nombre"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "direction", source = "direccion"),
            @Mapping(target = "phone", source = "telefono"),

    })
    ClientDTO toClienteDTO(Cliente cliente);
    List<ClientDTO> toClienteDTO(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(ClientDTO clienteDTO);
    List<Cliente> toClientes(List<ClientDTO> clienteDTO);


}
