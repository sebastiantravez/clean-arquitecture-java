package com.example.clean.archicture.pichincha.usecases.impl;

import com.example.clean.archicture.pichincha.entities.ClientCore;
import com.example.clean.archicture.pichincha.ports.ClientDomain;
import com.example.clean.archicture.pichincha.usecases.api.GetClientByDniUseCase;
import com.example.clean.archicture.pichincha.usecases.api.SaveClientUseCase;

import java.util.Optional;

public class SaveClientUseCaseImpl implements SaveClientUseCase {

    private final ClientDomain clientDomain;
    private final GetClientByDniUseCase getClientByDniUseCase;

    public SaveClientUseCaseImpl(ClientDomain clientDomain, GetClientByDniUseCase getClientByDniUseCase) {
        this.clientDomain = clientDomain;
        this.getClientByDniUseCase = getClientByDniUseCase;
    }

    @Override
    public void execute(ClientCore clientCore) {
        Optional<ClientCore> findClient = getClientByDniUseCase.execute(clientCore.getDni());
        if (findClient.isPresent()) {
            throw new RuntimeException("Cliente ya existe");
        }
        clientDomain.saveClient(clientCore);
    }

}
