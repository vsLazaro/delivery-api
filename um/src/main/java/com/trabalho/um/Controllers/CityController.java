package com.trabalho.um.Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.um.Service.CityService;
import com.trabalho.um.domain.model.City;


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
  public ResponseEntity<HashMap<String, Boolean>> cepIsServed(@PathVariable String cep)
  {
    HashMap<String, Boolean> response = new HashMap<String, Boolean>();
    response.put("message", this.service.cepIsServed(cep));
    return new ResponseEntity<HashMap<String, Boolean>>(response, HttpStatus.OK);
  }

}