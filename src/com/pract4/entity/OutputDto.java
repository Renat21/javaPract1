package com.pract4.entity;

import java.time.LocalDate;
import java.util.Set;

public record OutputDto(LocalDate date, Set<String> employees) {

    @Override
    public String toString() {
        return date + " - " + String.join(", ", employees);
    }
}
