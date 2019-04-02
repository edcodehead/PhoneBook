package com.claim;

public class Person {
	private String firstName;
	private String middleName1;
	private String middleName2;
	private String lastName;
	private String phoneNumber;
	private Address address;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public Person(String firstName, String lastName, String phoneNumber, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName1() {
		return this.middleName1;
	}
	
	public void setMiddleName1(String middleName1) {
		this.middleName1 = middleName1;
	}
	
	public String getMiddleName2() {
		return this.middleName2;
	}
	
	public void setMiddleName2(String middleName2) {
		this.middleName2 = middleName2;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName1=" + middleName1 + ", middleName2=" + middleName2
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	
//	public String searchByFirstName(String firstName) {
//		
//	}

}
