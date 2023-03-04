package com.example.clean.archicture.clean.repository;


import com.example.clean.archicture.clean.entities.Account;
import com.example.clean.archicture.clean.entities.Client;
import com.example.clean.archicture.clean.entities.enums.AccountType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByAccountNumber(@NotBlank String accountNumber);

    Optional<Account> findByAccountTypeAndClient(AccountType accountType, Client client);

    @Query("SELECT a " +
            "FROM Account a " +
            "JOIN a.client c " +
            "WHERE a.accountNumber like CONCAT('%',:searchValue,'%') " +
            "OR LOWER(c.fullName) like LOWER(CONCAT('%',:searchValue,'%')) ")
    List<Account> findByNameIgnoreCase(String searchValue);

    @Query("SELECT a FROM Account a ORDER BY a.createDate DESC")
    List<Account> findAllAccounts();

    List<Account> findByClient(Client client);

    @Query("SELECT a " +
            "FROM Account a " +
            "JOIN a.client c " +
            "JOIN a.movements m " +
            "WHERE c.id = :clientId " +
            "AND m.movementDate between :initDate and :endDate " +
            "AND a.accountType = :accountType " +
            "ORDER BY m.movementDate DESC")
    Optional<Account> findAccountsMovements(Long clientId, AccountType accountType, Date initDate, Date endDate);
}