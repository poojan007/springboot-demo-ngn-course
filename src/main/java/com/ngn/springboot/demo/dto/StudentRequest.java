package com.ngn.springboot.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentRequest {

	private String name;
	private String passportNumber;
	private List<String> courses = new ArrayList<String>();
	
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
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
