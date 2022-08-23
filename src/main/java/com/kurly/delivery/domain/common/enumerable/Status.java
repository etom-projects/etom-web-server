package com.kurly.delivery.domain.common.enumerable;

public enum Status {
    ACTIVE("ACTIVE"),
    DISABLE("DISABLE"),
    DELETE("DELETE");

    private final String value;

    private Status(String value) {
        this.value = value;
    }
}