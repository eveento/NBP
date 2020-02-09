package com.example.demo.enums;

public enum TableKind {

    A("a"),
    B("b"),
    C("c");

    private String name;

    TableKind(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TableKind findName(String name) {
        for ( TableKind tableKind : TableKind.values())
        {
            if(tableKind.getName().equalsIgnoreCase(name)){
                return TableKind.valueOf(tableKind.getName().toUpperCase());
            }
        }
        return null;
    }

}
