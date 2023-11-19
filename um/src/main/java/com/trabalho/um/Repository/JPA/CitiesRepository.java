package com.trabalho.um.Repository.JPA;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.trabalho.um.Repository.ICitiesRepository;
import com.trabalho.um.domain.entity.CityJPA;

@Component
public class CitiesRepository implements ICitiesRepository {
  private CitiesRepositoryJPA citiesRepositoryJPA;

  public CitiesRepository(CitiesRepositoryJPA citiesRepositoryJPA) {
    this.citiesRepositoryJPA = citiesRepositoryJPA;
  }

  @Override
  public ArrayList<CityJPA> getAllCities() {
    return citiesRepositoryJPA.findAll();
  }

  @Override
  public CityJPA getCityByName(String name) throws Exception {
    return citiesRepositoryJPA.findByName(name);
  }
  
}
