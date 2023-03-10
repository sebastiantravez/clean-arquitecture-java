package com.example.clean.archicture.clean.repository;

import com.example.clean.archicture.clean.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByDni(String dni);

    @Query("SELECT c FROM Client c ORDER BY c.createDate DESC")
    List<Client> findAllClients();
}
