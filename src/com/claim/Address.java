package com.claim;

public class Address {
	private String street;
	private String city;
	private String stateAbbreviation;
	private String zip;
	
	public Address() {}
	
	public Address(String street, String city, String stateAbbreviation, String zip) {
		this.street = street;
		this.city = city;
		this.stateAbbreviation = stateAbbreviation;
		this.zip = zip;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStateAbbreviation() {
		return this.stateAbbreviation;
	}
	
	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}
	
	public String getZip() {
		return this.zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getFullAddress() {
		return street + ", " + city + ", " + stateAbbreviation + " " + zip;
	}

	@Override
	public String toString() {
		return street + ", " + city + ", " + stateAbbreviation + " " + zip;
	}
	
	
}
