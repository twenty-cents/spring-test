package co.simplon.cityspringtest.service;

import co.simplon.cityspringtest.model.Monument;

import java.util.List;

public interface MonumentService {

	List<Monument> getAllCityMonuments(String cityName);

	Monument getMonumentByCityAndName(String cityName, String name);

	Monument saveMonumentToCity(String cityName, Monument monument);

}
