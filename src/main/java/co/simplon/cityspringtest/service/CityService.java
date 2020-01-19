package co.simplon.cityspringtest.service;

import co.simplon.cityspringtest.model.City;

import java.util.List;

public interface CityService {

	List<City> getAllCities();

	City getCityByName(String name);

	City saveCity(City city);

}
