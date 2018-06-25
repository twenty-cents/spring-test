package co.simplon.cityspringtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.cityspringtest.model.City;

@Service
public class CityServiceImpl implements CityService {

	@Override
	public List<City> getAllCities() {
		return new ArrayList<>();
	}
	
	@Override
	public City getCityByName(String name) {
		return new City("Paris", 75);
	}

	@Override
	public City saveCity(City city) {
		return city;
	}

}
