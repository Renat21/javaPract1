package com.pract2.enitites;


public class ResultDTO {

    private final double cost;

    private final String date;

    private final long count;

    public ResultDTO(long count, String date, double cost) {
        this.cost = cost;
        this.date = date;
        this.count = count;
    }

    @Override
    public String toString() {
        return date + " " + count + " " + cost;
    }
}
