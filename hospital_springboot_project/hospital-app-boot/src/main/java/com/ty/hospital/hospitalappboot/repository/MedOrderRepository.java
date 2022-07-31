package com.ty.hospital.hospitalappboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer> {
	
	@Query("SELECT M FROM MedOrder M WHERE M.encounter.id= :encounterid")
	public List<MedOrder> getAllMedOrderByEncounterId(int encounterid);
}
