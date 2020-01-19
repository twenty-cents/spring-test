package co.simplon.cityspringtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer dptCode;

	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<Monument> monuments;

	protected City() {}

	public City(String name, Integer dptCode) {
		this.name = name;
		this.dptCode = dptCode;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public Integer getDptCode() {
		return this.dptCode;
	}

	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDptCode(Integer dptCode) {
		this.dptCode = dptCode;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

}
