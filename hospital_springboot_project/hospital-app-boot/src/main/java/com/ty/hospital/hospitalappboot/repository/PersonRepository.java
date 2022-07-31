package com.ty.hospital.hospitalappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
