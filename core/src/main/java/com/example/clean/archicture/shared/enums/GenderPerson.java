package com.example.clean.archicture.shared.enums;

public enum GenderPerson {
    MASCULINO,
    FEMENINO,
    OTRO;

    public String getName() {
        return this.name().toLowerCase();
    }
}