package com.ty.hospital.hospitalappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
