package com.pract4.entity;

public class Tea {

    private final Long id;

    private final String name;

    private final TeaType teaType;

    public Tea(Long id, String name, TeaType teaType) {
        this.id = id;
        this.name = name;
        this.teaType = teaType;
    }

    public Long getId() {
        return id;
    }

    public TeaType getTeaType() {
        return teaType;
    }
}
