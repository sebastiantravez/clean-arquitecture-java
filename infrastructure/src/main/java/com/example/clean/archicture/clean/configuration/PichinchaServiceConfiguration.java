package com.example.clean.archicture.clean.configuration;

import com.example.clean.archicture.pichincha.ports.ClientDomain;
import com.example.clean.archicture.pichincha.usecases.api.GetClientByDniUseCase;
import com.example.clean.archicture.pichincha.usecases.api.SaveClientUseCase;
import com.example.clean.archicture.pichincha.usecases.impl.GetClientByDniUseCaseImpl;
import com.example.clean.archicture.pichincha.usecases.impl.SaveClientUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PichinchaServiceConfiguration {

    @Bean
    public ModelMapper modelMapperWithoutStrict() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public SaveClientUseCase saveClientUseCase(ClientDomain clientDomain, GetClientByDniUseCase getClientByDniUseCase) {
        return new SaveClientUseCaseImpl(clientDomain, getClientByDniUseCase);
    }

    @Bean
    public GetClientByDniUseCase getClientByDniUseCase(ClientDomain clientDomain) {
        return new GetClientByDniUseCaseImpl(clientDomain);
    }
}
