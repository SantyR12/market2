package com.example.market.infraestructura.repositories;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.repository.IClient;
import com.example.market.infraestructura.crud.ClienteRepository;
import com.example.market.infraestructura.entity.Cliente;
import com.example.market.infraestructura.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public void create(ClientDTO clientDTO) {
        Cliente cliente = clienteMapper.toCliente(clientDTO);
        clienteRepository.save(cliente);

    }

    public void update(ClientDTO clientDTO) {
        if (clientDTO.getId() == null) {
            throw new NullPointerException("ID es requerido en el campo");

        }
        Cliente clienteExistente = clienteRepository.findById(clientDTO.getId())
                .orElseThrow(() -> new RuntimeException("cliente no encontrado con id: " + clientDTO.getId()));

        Cliente clienteActualizado = clienteMapper.toCliente(clientDTO);
        clienteActualizado.setId(clienteExistente.getId());

        clienteRepository.save(clienteActualizado);


    }
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
