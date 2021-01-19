package com.ngn.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.springboot.demo.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
