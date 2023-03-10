package com.example.clean.archicture.clean.entities;

import com.example.clean.archicture.clean.entities.enums.GenderPerson;
import com.example.clean.archicture.clean.entities.enums.IdentificationPattern;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String fullName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private GenderPerson genderPerson;
    @Positive
    private Integer age;
    @NotNull
    private String dni;
    @NotNull
    @Enumerated(EnumType.STRING)
    private IdentificationPattern identificationPattern;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @Builder.Default
    @NotNull(message = "Fecha no puede ser null")
    private Date createDate = new Date();
}
