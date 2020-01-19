package co.simplon.cityspringtest.model;

import javax.persistence.*;

@Entity
public class Monument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "city_idx", nullable = false)
	private City city;

	protected Monument() {}

	public Monument(String name, City city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public City getCity() {
		return city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
