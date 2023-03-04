package com.example.clean.archicture.clean.entities.enums;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum AmountLimit {
    LIMIT_DAY(BigDecimal.valueOf(1000));

    private final BigDecimal value;

    AmountLimit(BigDecimal value) {
        this.value = value;
    }

}
