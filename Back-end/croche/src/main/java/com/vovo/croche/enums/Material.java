package com.vovo.croche.enums;

public enum Material {
    COTTON("Feito de algodão"),
    WOOL("Feito de lã"),
    SILK("Feito de seda");


    private final String description;

    Material(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
