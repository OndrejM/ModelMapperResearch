package sk.mihalyi.research.modelMapper.model;

public class Address {
	private String street;
	private String city;
	private String postalCode;
	private String country;
	
	
	public Address() {
	}

	Address(String street, String city, String postalCode, String country) {
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCountry() {
		return country;
	}
	
}
