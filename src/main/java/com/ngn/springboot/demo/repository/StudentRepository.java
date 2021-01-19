package com.ngn.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngn.springboot.demo.dto.StudentResponseWithPassport;
import com.ngn.springboot.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(name = "get_student_with_passport")
	List<StudentResponseWithPassport> getAllStudentsWithPassport();
	
	@Query(name = "get_students_with_some_name")
	List<Student> getAllStudents();
}
