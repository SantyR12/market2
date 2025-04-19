package com.example.market.controller;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public List<ClientDTO> obtenerCliente(){
        return clientService.obtenerTodo();

    }
    @GetMapping("/{id}")
    public ClientDTO obtenerClientePorId(@PathVariable Long id){
        return clientService.obtenerClientePorId(id);
    }
    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO){
        return clientService.crearCliente(clientDTO);
    }
    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable("id") Long id,@RequestBody ClientDTO clientDTO){
        return clientService.actualizarCliente(id,clientDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.eliminarCliente(id);
    }

}
