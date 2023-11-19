package com.trabalho.um.Repository.JPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trabalho.um.domain.entity.CityJPA;

public interface CitiesRepositoryJPA extends CrudRepository<CityJPA, Integer> {
    CityJPA findByName(String name);

    List<CityJPA> findById(int id);

    ArrayList<CityJPA> findAll();
}
