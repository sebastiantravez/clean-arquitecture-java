package com.example.clean.archicture.clean.dto;

import com.example.clean.archicture.clean.entities.enums.MovementType;
import com.example.clean.archicture.clean.entities.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovementsDTO {
    private Long movementId;
    private Date movementDate;
    private MovementType movementType;
    private BigDecimal movementAmount;
    private BigDecimal balanceAvailable;
    private TransactionType transactionType;
    private AccountDTO account;
    private String observation;
}
