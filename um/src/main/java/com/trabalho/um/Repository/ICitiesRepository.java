package com.trabalho.um.Repository;

import java.util.ArrayList;

import com.trabalho.um.domain.entity.CityJPA;

public interface ICitiesRepository {
    public ArrayList<CityJPA> getAllCities();
    public CityJPA getCityByName(String name) throws Exception;
}
