package com.example.clean.archicture.clean.service;


import com.example.clean.archicture.clean.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    void save(ClientDTO clientDTO);

    ClientDTO updateClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClients();

    void deleteClientById(Long clientId);

}
