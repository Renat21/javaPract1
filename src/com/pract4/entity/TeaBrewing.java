package com.pract4.entity;

import java.time.LocalDateTime;

public class TeaBrewing {

    private final String name;

    private final Tea tea;

    private final LocalDateTime from;

    private final LocalDateTime to;

    private final int temp;

    public TeaBrewing(String name, Tea tea, LocalDateTime from, LocalDateTime to, int temp) {
        this.name = name;
        this.tea = tea;
        this.from = from;
        this.to = to;
        this.temp = temp;
    }

    public Tea getTea() {
        return tea;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public int getTemp() {
        return temp;
    }
}
