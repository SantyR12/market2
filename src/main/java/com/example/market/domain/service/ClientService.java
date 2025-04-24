package com.example.market.domain.service;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructura.repositories.ClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClienteImpl clienteImpl;


    public List<ClientDTO> obtenerTodo() {
        return clienteImpl.getAll();
    }
    public Optional<ClientDTO> obtenerClientePorId(Long id) {
        return clienteImpl.getById(id);
    }
    public ClientDTO crearCliente(ClientDTO clientDTO) {
        return clienteImpl.create(clientDTO);
    }
    public ClientDTO actualizarCliente(ClientDTO clientDTO) {
        return clienteImpl.update(clientDTO);
    }
    public void eliminarCliente(Long id) {
        clienteImpl.delete(id);

    }

}
