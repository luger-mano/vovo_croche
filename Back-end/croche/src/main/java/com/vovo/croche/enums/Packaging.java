package com.vovo.croche.enums;

public enum Packaging {
    INDIVIDUALLY_WRAPPED("Embalado individualmente"),
    SEASONAL_EDITION("Edição Sazonal"),
    PREMIUM_PACKAGING("Embalagem premium");

    private final String description;

    Packaging(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
