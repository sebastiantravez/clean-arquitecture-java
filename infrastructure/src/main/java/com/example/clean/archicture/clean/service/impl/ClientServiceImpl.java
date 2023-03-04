package com.example.clean.archicture.clean.service.impl;

import com.example.clean.archicture.clean.dto.ClientDTO;
import com.example.clean.archicture.clean.entities.Client;
import com.example.clean.archicture.clean.exception.GenericException;
import com.example.clean.archicture.clean.repository.ClientRepository;
import com.example.clean.archicture.clean.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(ClientDTO clientDTO) {
        Optional<Client> clientExist = clientRepository.findByDni(clientDTO.getDni());
        if (clientExist.isPresent()) {
            throw new GenericException(HttpStatus.BAD_REQUEST, "Cliente ya existe");
        }
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setCreateDate(new Date());
        clientRepository.save(client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientRepository.findByDni(clientDTO.getDni())
                .orElseThrow(() -> new GenericException(HttpStatus.NOT_FOUND, "Cliente no existe, no se puede actualizar datos"));
        client.setFullName(clientDTO.getFullName());
        client.setGenderPerson(clientDTO.getGenderPerson());
        client.setAge(clientDTO.getAge());
        client.setDni(clientDTO.getDni());
        client.setIdentificationPattern(clientDTO.getIdentificationPattern());
        client.setAddress(clientDTO.getAddress());
        client.setPhone(clientDTO.getPhone());
        client.setStatus(clientDTO.getStatus());
        client.setPassword(clientDTO.getPassword());
        clientRepository.save(client);
        return clientDTO;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientDTO> clientDTOS = clientRepository.findAllClients().stream()
                .filter(client -> client.getStatus())
                .map(this::buildClienteDTO)
                .collect(Collectors.toList());
        return clientDTOS;
    }

    @Override
    public void deleteClientById(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() ->
                new GenericException(HttpStatus.NOT_FOUND, "Cliente no existe, no se puede eliminar"));
        client.setStatus(Boolean.FALSE);
        clientRepository.save(client);
    }

    private ClientDTO buildClienteDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

}
