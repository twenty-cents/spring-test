package co.simplon.cityspringtest.model;

public class Monument {

	private String name;
	private City city;

	protected Monument() {}

	public Monument(String name, City city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public City getCity() {
		return city;
	}

}
