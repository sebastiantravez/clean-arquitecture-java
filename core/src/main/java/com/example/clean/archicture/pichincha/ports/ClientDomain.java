package com.example.clean.archicture.pichincha.ports;

import com.example.clean.archicture.pichincha.entities.ClientCore;

public interface ClientDomain {
    void saveClient(ClientCore client);
}
