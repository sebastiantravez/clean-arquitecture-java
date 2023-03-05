package com.example.clean.archicture.pichincha.usecases.impl;

import com.example.clean.archicture.pichincha.entities.ClientCore;
import com.example.clean.archicture.pichincha.ports.ClientDomain;
import com.example.clean.archicture.pichincha.usecases.api.SaveClientUseCase;

public class SaveClientUseCaseImpl implements SaveClientUseCase {

    private final ClientDomain clientDomain;

    public SaveClientUseCaseImpl(ClientDomain clientDomain) {
        this.clientDomain = clientDomain;
    }

    @Override
    public void execute(ClientCore clientCore) {
        clientDomain.saveClient(clientCore);
    }

}
