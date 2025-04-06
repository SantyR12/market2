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
    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody ClientDTO clientDTO){
        clientService.crearCliente(clientDTO);
        return new ResponseEntity<>("cliente guardado", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id,@RequestBody ClientDTO clientDTO){
        clientDTO.setId(id);
        clientService.actualizarCliente(clientDTO);
        return new ResponseEntity<>("cliente actualizado", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.eliminarCliente(id);
        return new ResponseEntity<>("cliente eliminado", HttpStatus.OK);
    }

}
