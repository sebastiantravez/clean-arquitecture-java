package com.example.clean.archicture.clean.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Client extends Person{
    @NotNull
    private String password;
    @NotNull
    private Boolean status = Boolean.TRUE;
    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client", fetch = FetchType.EAGER)
    private List<Account> accounts;
}
