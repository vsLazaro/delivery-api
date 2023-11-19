package com.trabalho.um.Repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.trabalho.um.domain.model.City;

@Component
public class CitiesMemoryRepository implements ICitiesRepository {
  private ArrayList<City> cities = new ArrayList<>();

  public CitiesMemoryRepository()
  {
    City city1 = new City("Porto Alegre", 25);
    City city2 = new City("São Paulo", 10);
    City city3 = new City("Florianópolis", 20);
    this.cities.add(city1);
    this.cities.add(city2);
    this.cities.add(city3);
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
    throw new Exception("Não atendemos a cidade " + name);
  }

}
