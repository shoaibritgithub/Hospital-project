package com.ty.hospital.hospitalappboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
	
	@Query("SELECT B FROM Branch B WHERE B.hospital.id= :hospitalid")
	public List<Branch> getAllBranchByHospitalId(int hospitalid);

}
