package com.trabalho.um.domain.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.trabalho.um.domain.Repository.City;
import com.trabalho.um.domain.Repository.ICepRepository;
import com.trabalho.um.domain.Repository.ICitiesRepository;

@Service
public class CityService {
  private ICitiesRepository citiesRepository;
  private ICepRepository cepRepository;

  public CityService(ICitiesRepository citiesRepository, ICepRepository cepRepository)
  {
    this.citiesRepository = citiesRepository;
    this.cepRepository = cepRepository;
  }

  public boolean cepIsServed(String cep)
  {
    try {
      String city = this.cepRepository.getCityNameByCep(cep);
      City objCity = this.citiesRepository.getCityByName(city);
      if(objCity.getName().length() > 0) {
        return true;
      } 
      return false;
    } catch (Exception e) {
        System.out.println("AQUI");
        return false;
    }
  }

  public ArrayList<City> getServedCities()
  {
    return this.citiesRepository.getAllCities();
  }
}
