package co.simplon.cityspringtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.cityspringtest.model.Monument;

@Service
public class MonumentServiceImpl implements MonumentService {

	@Override
	public List<Monument> getAllCityMonuments(String cityName) {
		return new ArrayList<>();
	}

	@Override
	public Monument getMonumentByCityAndName(String cityName, String name) {
		return new Monument("Tour Eiffel", null);
	}

	@Override
	public Monument saveMonumentToCity(String cityName, Monument monument) {
		return monument;
	}

}
