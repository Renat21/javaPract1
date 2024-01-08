package com.pract2.enitites;

public class Product {
    private String id;

    private String name;

    private String description;

    private Double weight;

    private Long cost;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
