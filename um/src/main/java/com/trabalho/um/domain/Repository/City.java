package com.trabalho.um.domain.Repository;

public class City {
    String name;
    double cost;

    public City(String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public String getName()
    {
        return this.name;
    }

    public double getCost()
    {
        return this.cost;
    }
}
