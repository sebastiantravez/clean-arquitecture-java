package com.example.clean.archicture.clean.service;


import com.example.clean.archicture.clean.dto.AccountDTO;
import com.example.clean.archicture.clean.dto.AccountReportDTO;
import com.example.clean.archicture.clean.entities.enums.AccountType;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface AccountService {
    void saveAccount(AccountDTO accountDTO);

    AccountDTO updateAccount(AccountDTO accountDTO);

    void deleteAccount(Long accountId);

    List<AccountDTO> getAllAccounts();

    List<AccountDTO> getAccountsByClient(Long clientId);

    AccountReportDTO getAccountStatus(Long clientId, AccountType accountType, Date initDate, Date endDate) throws IOException;
}
