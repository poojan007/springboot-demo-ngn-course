package com.ngn.springboot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.springboot.demo.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {

	Optional<Passport> findByPassportNumber(String passportNumber);
}
