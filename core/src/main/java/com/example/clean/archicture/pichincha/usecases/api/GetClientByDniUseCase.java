package com.example.clean.archicture.pichincha.usecases.api;

import com.example.clean.archicture.pichincha.entities.ClientCore;

import java.util.Optional;

public interface GetClientByDniUseCase {
    Optional<ClientCore> execute(String dni);
}
