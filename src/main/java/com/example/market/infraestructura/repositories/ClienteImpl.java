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
    public ClientDTO getById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return clienteMapper.toClienteDTO(cliente);


    }


    public ClientDTO create(ClientDTO clientDTO) {
        Cliente cliente = clienteMapper.toCliente(clientDTO);
        return clienteMapper.toClienteDTO(clienteRepository.save(cliente));

    }

    public ClientDTO update(Long id,ClientDTO clientDTO) {
      Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
      Cliente clienteUpdate = clienteMapper.toCliente(clientDTO);
      cliente.setNombre(clienteUpdate.getNombre());
      cliente.setEmail(clienteUpdate.getEmail());
      cliente.setDireccion( clienteUpdate.getDireccion());
      cliente.setTelefono(clienteUpdate.getTelefono());
      return clienteMapper.toClienteDTO(clienteRepository.save(cliente));
    }
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
