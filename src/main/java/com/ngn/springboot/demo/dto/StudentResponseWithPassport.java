package com.ngn.springboot.demo.dto;

public class StudentResponseWithPassport {

	private String name;
	private String passportNumber;
	
	public StudentResponseWithPassport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentResponseWithPassport(String name, String passportNumber) {
		super();
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
}
