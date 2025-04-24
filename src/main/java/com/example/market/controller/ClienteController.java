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
    public ResponseEntity<ClientDTO> obtenerClientePorId(@PathVariable Long id){
        return clientService.obtenerClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
        ClientDTO savedClient = clientService.crearCliente(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO.setId(id);
        ClientDTO actualizado = clientService.actualizarCliente(clientDTO);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.eliminarCliente(id);
        return new ResponseEntity<>("cliente eliminado", HttpStatus.OK);
    }

}
