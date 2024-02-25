package com.pract4.entity;

public class TeaType {

    private final Long id;

    private final String name;

    private final int timeFrom;

    private final int timeTo;

    private final int tempFrom;

    private final int tempTo;

    public TeaType(Long id, String name, int timeFrom, int timeTo, int tempFrom, int tempTo) {
        this.id = id;
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.tempFrom = tempFrom;
        this.tempTo = tempTo;
    }

    public int getTempFrom() {
        return tempFrom;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public Long getId() {
        return id;
    }


    public int getTempTo() {
        return tempTo;
    }
}
