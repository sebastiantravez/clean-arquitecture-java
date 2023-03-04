package com.example.clean.archicture.clean.configuration;

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

}
