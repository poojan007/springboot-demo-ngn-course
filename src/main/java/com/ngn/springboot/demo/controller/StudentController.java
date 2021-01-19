package com.ngn.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.springboot.demo.dto.StudentRequest;
import com.ngn.springboot.demo.dto.StudentResponseWithPassport;
import com.ngn.springboot.demo.entity.Course;
import com.ngn.springboot.demo.entity.Passport;
import com.ngn.springboot.demo.entity.Student;
import com.ngn.springboot.demo.repository.CourseRepository;
import com.ngn.springboot.demo.repository.PassportRepository;
import com.ngn.springboot.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private PassportRepository passportRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@PostMapping("/addStudentWithPassport")
	public ResponseEntity<Student> addStudentWithPassport(@RequestBody StudentRequest request){
		Passport passport = new Passport();
		if(passportRepo.findByPassportNumber(request.getPassportNumber()).isPresent()) {
			passport = passportRepo.findByPassportNumber(request.getPassportNumber()).get();
		} else {
			passport.setPassportNumber(request.getPassportNumber());
			passport = passportRepo.save(passport);
		}
		
		Student student = new Student();
		student.setName(request.getName());
		student.setPassport(passport);
		
		Student insertedStudent = studentRepo.save(student);
		
		return new ResponseEntity<Student>(insertedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudentsWithPassport")
	public ResponseEntity<List<StudentResponseWithPassport>> getAllStudentsWithPassport(){
		List<StudentResponseWithPassport> studentList = studentRepo.getAllStudentsWithPassport();
		return new ResponseEntity<List<StudentResponseWithPassport>>(studentList, HttpStatus.OK);
	}
	
	@PostMapping("/addStudentWithCourses")
	public ResponseEntity<Student> addStudentWithCourse(@RequestBody StudentRequest request){
		Student student = new Student();
		student.setName(request.getName());
		
		request.getCourses().stream().forEach(courseName -> {
			Course course = courseRepo.findByName(courseName);
			if(null == course) {
				course = new Course();
				course.setStudents(new ArrayList<Student>());
			} 
			
			course.setName(courseName);
			student.addCourse(course);
		});
		
		return new ResponseEntity<Student>(studentRepo.save(student), HttpStatus.CREATED);
	}
}
