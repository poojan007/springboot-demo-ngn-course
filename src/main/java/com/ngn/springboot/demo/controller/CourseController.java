package com.ngn.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.springboot.demo.entity.Course;
import com.ngn.springboot.demo.repository.CourseRepository;

@RestController
public class CourseController {
	
	//testing hellow hello

	@Autowired
	private CourseRepository courseRepo;
	
	@PostMapping("/saveCourse")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		return new ResponseEntity<Course>(courseRepo.save(course), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses(){
		return new ResponseEntity<List<Course>>(courseRepo.findAll(), HttpStatus.OK);
	}
}
