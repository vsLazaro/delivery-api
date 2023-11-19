package com.trabalho.um.Service;

import java.util.ArrayList;

import com.trabalho.um.domain.model.City;

public interface ICityService {
  public boolean cepIsServed(String cep);
  public ArrayList<City> getServedCities();
  public City getCityByCep(String cep) throws Exception;
  public City geCityByName(String name) throws Exception;
}
