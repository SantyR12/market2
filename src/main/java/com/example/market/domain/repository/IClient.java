package com.example.market.domain.repository;
import java.util.List;

import com.example.market.domain.dto.ClientDTO;


public interface IClient {

    List<ClientDTO> getAll();

    void create(ClientDTO clientDTO);
    void update(ClientDTO clientDTO);
    void delete(Long id);

}





