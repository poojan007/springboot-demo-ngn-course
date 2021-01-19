package com.ngn.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.springboot.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findByName(String courseName);
}
