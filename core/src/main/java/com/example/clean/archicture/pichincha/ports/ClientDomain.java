package com.example.clean.archicture.pichincha.ports;

import com.example.clean.archicture.pichincha.entities.ClientCore;

import java.util.Optional;

public interface ClientDomain {
    void saveClient(ClientCore client);
    Optional<ClientCore> getClient(String clientDni);
}
