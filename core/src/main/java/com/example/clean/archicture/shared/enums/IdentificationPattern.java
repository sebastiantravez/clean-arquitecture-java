package com.example.clean.archicture.shared.enums;

public enum IdentificationPattern {
    CEDULA,
    RUC,
    PASAPORTE;

    public String getName() {
        return this.name().toLowerCase();
    }

}
