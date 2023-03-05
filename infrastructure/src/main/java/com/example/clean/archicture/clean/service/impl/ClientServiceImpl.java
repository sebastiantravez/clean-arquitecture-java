package com.example.clean.archicture.clean.service.impl;

import com.example.clean.archicture.clean.entities.Client;
import com.example.clean.archicture.clean.repository.ClientRepository;
import com.example.clean.archicture.pichincha.entities.ClientCore;
import com.example.clean.archicture.pichincha.ports.ClientDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientDomain {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveClient(ClientCore clientCore) {
        Client client = modelMapper.map(clientCore, Client.class);
        clientRepository.save(client);
    }

    @Override
    public Optional<ClientCore> getClient(String clientDni) {
        Client client = clientRepository.findByDni(clientDni).orElse(null);
        return client != null ? Optional.of(modelMapper.map(client, ClientCore.class)) : Optional.ofNullable(null);
    }

}
