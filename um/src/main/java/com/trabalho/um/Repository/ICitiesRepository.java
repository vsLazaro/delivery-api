package com.trabalho.um.Repository;

import java.util.ArrayList;

import com.trabalho.um.domain.model.City;

public interface ICitiesRepository {
    public ArrayList<City> getAllCities();
    public City getCityByName(String name) throws Exception;
}
