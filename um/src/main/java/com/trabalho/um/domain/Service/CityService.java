package com.trabalho.um.domain.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.trabalho.um.domain.Repository.ICepRepository;
import com.trabalho.um.domain.Repository.ICitiesRepository;
import com.trabalho.um.domain.model.City;

@Service
public class CityService implements ICityService {
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

  public City getCityByCep(String cep) throws Exception
  {
    try {
      if(!this.cepIsServed(cep)) {
        throw new Exception("Não atendemos o CEP " + cep);
      }
      String cityName = this.cepRepository.getCityNameByCep(cep);
      return this.citiesRepository.getCityByName(cityName);
    } catch(Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public City geCityByName(String name) throws Exception
  {
    try {
      return this.citiesRepository.getCityByName(name);
    } catch(Exception e) {
      throw new Exception(e.getMessage());
    }
  }
}