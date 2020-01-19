package co.simplon.cityspringtest.repository;

import co.simplon.cityspringtest.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument, Long> {

	List<Monument> findAllByCityName(String cityName);
	
	Monument findByCityNameAndName(String cityName, String monumentName);

}
