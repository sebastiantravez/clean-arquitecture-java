package com.example.clean.archicture.clean.service.impl;

import com.example.clean.archicture.clean.entities.Client;
import com.example.clean.archicture.pichincha.entities.ClientCore;
import com.example.clean.archicture.clean.exception.GenericException;
import com.example.clean.archicture.clean.repository.ClientRepository;
import com.example.clean.archicture.pichincha.ports.ClientDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientDomain {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveClient(ClientCore clientCore) {
        Optional<Client> clientExist = clientRepository.findByDni(clientCore.getDni());
        if (clientExist.isPresent()) {
            throw new GenericException(HttpStatus.BAD_REQUEST, "Cliente ya existe");
        }
        Client client = modelMapper.map(clientCore, Client.class);
        client.setCreateDate(new Date());
        clientRepository.save(client);
    }

}
