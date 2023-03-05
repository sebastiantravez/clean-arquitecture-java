package com.example.clean.archicture.clean.mapper;

import com.example.clean.archicture.clean.dto.ClientDTO;
import com.example.clean.archicture.clean.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectClientMapper {
    ClientDTO toDto(Client objectEntity);

    Client toEntity(ClientDTO dto);
}
