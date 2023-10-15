package com.trabalho.um.domain.Repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class CitiesMemoryRepository implements ICitiesRepository {
  private ArrayList<City> cities = new ArrayList<>();

  public CitiesMemoryRepository()
  {
    City city1 = new City("Porto Alegre", 0);
    City city2 = new City("São Paulo", 0);
    this.cities.add(city1);
    this.cities.add(city2);
  }
  @Override
  public ArrayList<City> getAllCities() {
    return cities;
  }

  @Override
  public City getCityByName(String name) throws Exception {
    for(City city : cities) {
      if(city.getName().equals(name)) {
        return city;
      }
    }
    throw new Exception("Cidade não atendida");
  }

}