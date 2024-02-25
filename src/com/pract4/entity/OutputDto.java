package com.pract4.entity;

import java.time.LocalDate;
import java.util.Set;

public class OutputDto {

    private final LocalDate date;

    private final Set<String> employees;

    public OutputDto(LocalDate date, Set<String> employees) {
        this.date = date;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return date + " - " + String.join(",", employees);
    }
}
