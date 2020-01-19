package co.simplon.cityspringtest.controller;

import co.simplon.cityspringtest.model.City;
import co.simplon.cityspringtest.model.Monument;
import co.simplon.cityspringtest.service.CityService;
import co.simplon.cityspringtest.service.MonumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

	private CityService cityService;
	private MonumentService monumentService;

	public CityController(CityService cityService, MonumentService monumentService) {
		this.cityService = cityService;
		this.monumentService = monumentService;
	}

	@GetMapping
	public List<City> getCities() {
		return cityService.getAllCities();
	}

	@GetMapping("/{cityName}")
	public ResponseEntity<City> getCityByName(@PathVariable String cityName) {
		City city = cityService.getCityByName(cityName);

		if (city != null) {
			return new ResponseEntity<>(city, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{cityName}/monument")
	public List<Monument> getCityMonuments(@PathVariable String cityName) {
		return monumentService.getAllCityMonuments(cityName);
	}

	@GetMapping("/{cityName}/monument/{monumentName}")
	public ResponseEntity<Monument> getCityMonumentByName(@PathVariable String cityName,
			@PathVariable String monumentName) {
		Monument monument = monumentService.getMonumentByCityAndName(cityName, monumentName);

		if (monument != null) {
			return new ResponseEntity<>(monument, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<City> createCity(@RequestBody City newCity) {
		City newSavedCity = cityService.saveCity(newCity);

		return new ResponseEntity<>(newSavedCity, HttpStatus.OK);
	}

	@PostMapping("/{cityName}/monument")
	public ResponseEntity<Monument> createCityMonument(@PathVariable String cityName, @RequestBody Monument newMonument) {
		Monument newSavedMonument = this.monumentService.saveMonumentToCity(cityName, newMonument);

		if (newSavedMonument != null) {
			return new ResponseEntity<>(newSavedMonument, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
