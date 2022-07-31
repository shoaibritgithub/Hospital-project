package com.ty.hospital.hospitalappboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	@Query("SELECT I FROM Item I WHERE I.medorder.id = :medorderid")
	public List<Item> getAllItemByMedorderId(int medorderid);
}
