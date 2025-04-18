package com.example.market.infraestructura.repositories;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.repository.IClient;
import com.example.market.infraestructura.crud.ClienteRepository;
import com.example.market.infraestructura.entity.Cliente;
import com.example.market.infraestructura.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImpl implements IClient {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    public List<ClientDTO> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClienteDTO(clientes);

    }
    public Optional<ClientDTO> getById(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toClienteDTO);

    }


    public ClientDTO create(ClientDTO clientDTO) {
        Cliente entity = clienteMapper.toCliente(clientDTO);
        Cliente savedEntity = clienteRepository.save(entity);
        return clienteMapper.toClienteDTO(savedEntity);
    }

    public ClientDTO update(ClientDTO clientDTO) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clientDTO.getId());
        if (optionalCliente.isPresent()) {
            Cliente cliente = clienteMapper.toCliente(clientDTO);
            Cliente clienteActualizado = clienteRepository.save(cliente);
            return clienteMapper.toClienteDTO(clienteActualizado);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
