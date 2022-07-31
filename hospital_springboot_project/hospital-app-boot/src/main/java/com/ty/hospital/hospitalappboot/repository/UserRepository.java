package com.ty.hospital.hospitalappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
