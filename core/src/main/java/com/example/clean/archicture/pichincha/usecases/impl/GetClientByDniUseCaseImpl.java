package com.example.clean.archicture.pichincha.usecases.impl;

import com.example.clean.archicture.pichincha.entities.ClientCore;
import com.example.clean.archicture.pichincha.ports.ClientDomain;
import com.example.clean.archicture.pichincha.usecases.api.GetClientByDniUseCase;

import java.util.Optional;

public class GetClientByDniUseCaseImpl implements GetClientByDniUseCase {

    private final ClientDomain clientDomain;

    public GetClientByDniUseCaseImpl(ClientDomain clientDomain) {
        this.clientDomain = clientDomain;
    }

    @Override
    public Optional<ClientCore> execute(String dni) {
        return clientDomain.getClient(dni);
    }
}
