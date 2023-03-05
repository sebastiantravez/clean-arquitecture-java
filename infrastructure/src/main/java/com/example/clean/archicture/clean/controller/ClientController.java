package com.example.clean.archicture.clean.controller;

import com.example.clean.archicture.clean.dto.ClientDTO;
import com.example.clean.archicture.pichincha.entities.ClientCore;
import com.example.clean.archicture.pichincha.usecases.api.SaveClientUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private SaveClientUseCase saveClientUseCase;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveClient")
    public void saveClient(@RequestBody ClientDTO clientDTO) {
        saveClientUseCase.execute(modelMapper.map(clientDTO, ClientCore.class));
    }

}
