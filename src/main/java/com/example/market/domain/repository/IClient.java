package com.example.market.domain.repository;
import java.util.List;

import com.example.market.domain.dto.ClientDTO;


public interface IClient {
    List<ClientDTO> getAll();

    void create(ClientDTO client);

    void update(ClientDTO client);

    void delete(Long id);
}





