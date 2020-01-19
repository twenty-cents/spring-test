package co.simplon.cityspringtest.service;

import co.simplon.cityspringtest.model.City;
import co.simplon.cityspringtest.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CityServiceTests {

    @Mock
    CityRepository cityRepo;

    private CityService cityService;

    @BeforeEach
    public void setUp() throws Exception {
        cityService = new CityServiceImpl(cityRepo);
    }

    @Test
    public void getAllCities() {
        given(cityRepo.findAll()).willReturn(new ArrayList<>());

        List<City> cities = cityService.getAllCities();

        assertThat(cities).isNotNull();
    }

    @Test
    public void getCityByName() {
        given(cityRepo.findByNameIgnoreCase("Paris")).willReturn(new City("Paris", 75));

        City paris = cityService.getCityByName("Paris");

        assertThat(paris.getName()).isEqualTo("Paris");
        assertThat(paris.getDptCode()).isEqualTo(75);
    }

    @Test
    public void getCityByNameNotFound() {
        given(cityRepo.findByNameIgnoreCase("Minas Tirith")).willReturn(null);

        City notFoundCity = cityService.getCityByName("Minas Tirith");

        assertThat(notFoundCity).isNull();
    }

    @Test
    public void createCity() {
        City paris = new City("Paris", 75);
        given(cityRepo.save(paris)).willReturn(new City("Paris", 75));

        City savedParis = cityService.saveCity(paris);

        assertThat(savedParis.getName()).isEqualTo("Paris");
        assertThat(savedParis.getDptCode()).isEqualTo(75);
    }

}
