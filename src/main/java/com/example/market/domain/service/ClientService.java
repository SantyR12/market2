package com.example.market.domain.service;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructura.repositories.ClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClienteImpl clienteImpl;


    public List<ClientDTO> obtenerTodo() {
        return clienteImpl.getAll();
    }
    public void crearCliente(ClientDTO clientDTO) {
        clienteImpl.create(clientDTO);
    }
    public void actualizarCliente(ClientDTO clientDTO) {
        clienteImpl.update(clientDTO);
    }
    public void eliminarCliente(Long id) {
        clienteImpl.delete(id);

    }

}
