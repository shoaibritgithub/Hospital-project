package com.ty.hospital.hospitalappboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {
	
	@Query("SELECT E FROM Encounter E WHERE E.branch.id= :branchid AND E.person.id= :personid")
	public List<Encounter> getAllEncountersByPersonAndBranchId(int branchid,int personid);
}
