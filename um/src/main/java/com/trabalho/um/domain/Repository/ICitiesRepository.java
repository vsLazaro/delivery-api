package com.trabalho.um.domain.Repository;

import java.util.ArrayList;

public interface ICitiesRepository {
    public ArrayList<City> getAllCities();
    public City getCityByName(String name) throws Exception;
}
