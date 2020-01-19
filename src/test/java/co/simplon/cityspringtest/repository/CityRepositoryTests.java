package co.simplon.cityspringtest.repository;

import co.simplon.cityspringtest.model.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CityRepositoryTests {

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findCityByName() throws Exception {
        City savedCity = testEntityManager.persistFlushFind(new City("Toulouse", 31));
        City toulouse = this.cityRepo.findByNameIgnoreCase("Toulouse");
        assertThat(toulouse.getName()).isEqualTo(savedCity.getName());
        assertThat(toulouse.getDptCode()).isEqualTo(savedCity.getDptCode());
    }

    @Test
    public void findCityByNameIgnoreCase() throws Exception {
        City savedCity = testEntityManager.persistFlushFind(new City("Marseille", 13));
        City toulouse = this.cityRepo.findByNameIgnoreCase("marseille");
        assertThat(toulouse.getName()).isEqualTo(savedCity.getName());
        assertThat(toulouse.getDptCode()).isEqualTo(savedCity.getDptCode());
    }
}
