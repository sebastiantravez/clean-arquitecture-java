package com.example.clean.archicture.clean.dto;

import com.example.clean.archicture.clean.entities.enums.GenderPerson;
import com.example.clean.archicture.clean.entities.enums.IdentificationPattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long clientId;
    private String fullName;
    private GenderPerson genderPerson;
    private Integer age;
    private String dni;
    private IdentificationPattern identificationPattern;
    private String address;
    private String phone;
    private String password;
    private Boolean status;
}
