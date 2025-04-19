package com.example.market.domain.repository;
import java.util.List;


import com.example.market.domain.dto.ClientDTO;


public interface IClient {

    public List<ClientDTO> getAll();
    public ClientDTO getById(Long id);
    public ClientDTO create(ClientDTO clientDTO);
    public ClientDTO update(Long id ,ClientDTO clientDTO);
    public void  delete(Long id);


}





