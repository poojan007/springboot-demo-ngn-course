package com.ngn.springboot.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(
	 value = {
		 @NamedQuery(name = "get_students_with_some_name", query = "SELECT s FROM Student s WHERE name=?1"),
		 @NamedQuery(name = "get_student_with_passport", query = "SELECT new com.ngn.springboot.demo.dto.StudentResponseWithPassport(s.name, p.passportNumber) FROM Student s JOIN s.passport p")
	 })
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne
	private Passport passport;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "student_course",
				joinColumns = @JoinColumn(name = "STUDENT_ID"),
				inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
			)
	private List<Course> courses = new ArrayList<Course>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
}
