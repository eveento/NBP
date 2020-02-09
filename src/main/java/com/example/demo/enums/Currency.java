package com.example.demo.enums;

public enum Currency {
    CHF("frank_szwajcarski"),
    USD("dolar_amerykanski"),
    AUD("dolar_australijski"),
    EUR("euro");

    private String name;

    Currency(String name) {
        this.name = name;

    }
}
