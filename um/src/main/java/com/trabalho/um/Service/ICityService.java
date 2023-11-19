package com.trabalho.um.Service;

import java.util.ArrayList;

import com.trabalho.um.domain.entity.CityJPA;

public interface ICityService {
  public boolean cepIsServed(String cep);
  public ArrayList<CityJPA> getServedCities();
  public CityJPA getCityByCep(String cep) throws Exception;
  public CityJPA geCityByName(String name) throws Exception;
}
