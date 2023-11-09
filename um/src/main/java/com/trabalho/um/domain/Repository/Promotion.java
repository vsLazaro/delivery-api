package com.trabalho.um.domain.Repository;

public class Promotion {
    private int id;
    private String description;
    private double basicDiscount = 0;
    private double additionalDiscount = 0;
    private City city;
    private int minWeight;
    private int maxWeight;
    private boolean valid;

    public Promotion(String description, double basicDiscount, double additionalDiscount, City city, int minWeight,
        int maxWeight, int id) {
        this.description = description;
        this.basicDiscount = basicDiscount;
        this.additionalDiscount = additionalDiscount;
        this.city = city;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.valid = true;
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public City getcity() {
        return this.city;
    }
}