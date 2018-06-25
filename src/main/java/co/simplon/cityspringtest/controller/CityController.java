package co.simplon.cityspringtest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.cityspringtest.model.City;
import co.simplon.cityspringtest.model.Monument;

@RestController
@RequestMapping("/api/city")
public class CityController {

	@GetMapping
	public List<City> getCities() {
		return new ArrayList<>();
	}

	@GetMapping("/{cityName}")
	public ResponseEntity<City> getCityByName(@PathVariable String cityName) {
		return new ResponseEntity<City>(new City("Paris", 75), HttpStatus.OK);
	}

	@GetMapping("/{cityName}/monument")
	public List<Monument> getCityMonuments() {
		return new ArrayList<>();
	}

	@GetMapping("/{cityName}/monument/{monumentName}")
	public ResponseEntity<Monument> getCityMonumentByName(@PathVariable String cityName,
			@PathVariable String monumentName) {
		return new ResponseEntity<Monument>(new Monument("Tour Eiffel", null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<City> createCity(@RequestBody City newCity) {
		return new ResponseEntity<City>(new City("Toulouse", 31), HttpStatus.OK);
	}

	@PostMapping("/{cityName}/monument")
	public ResponseEntity<Monument> createCityMonument(@PathVariable String cityName, @RequestBody Monument newMonument) {
		return new ResponseEntity<Monument>(new Monument("Arc de Triomphe", null), HttpStatus.OK);
	}
}
