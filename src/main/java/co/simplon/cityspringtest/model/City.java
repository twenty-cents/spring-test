package co.simplon.cityspringtest.model;

public class City {

	private String name;
	private Integer dptCode;

	protected City() {}

	public City(String name, Integer dptCode) {
		super();
		this.name = name;
		this.dptCode = dptCode;
	}

	public String getName() {
		return this.name;
	}

	public Integer getDptCode() {
		return this.dptCode;
	}

}
