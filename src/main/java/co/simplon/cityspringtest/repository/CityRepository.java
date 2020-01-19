package co.simplon.cityspringtest.repository;

import co.simplon.cityspringtest.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {

	City findByName(@Param("nameToFind") String name);

}
