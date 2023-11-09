package com.trabalho.um.Controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.um.domain.Repository.City;
import com.trabalho.um.domain.Service.CityService;


@RestController
@RequestMapping({"/cities"})
public class CityController {

	private CityService service;

  public CityController(CityService service) {
    this.service = service;
  }

  @GetMapping()
  public ResponseEntity<ArrayList<City>> getCities()
  {
    return new ResponseEntity<ArrayList<City>>(this.service.getServedCities(), HttpStatus.OK);
  }

  @GetMapping({"/cep/{cep}"})
  public boolean cepIsServed(@PathVariable String cep)
  {
    return this.service.cepIsServed(cep);
  }

}