package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.MedOrder;
import com.ty.hospital.hospitalappboot.repository.MedOrderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepository medOrderRepository;

	@Autowired
	private EncounterDao encounterdao;

	public MedOrder saveMedOrder(int encounterid, MedOrder medorder) {

		Encounter encounter = encounterdao.getEncounterById(encounterid);

		if (encounter != null) {
			List<Item> items = medorder.getItems();
			if (items != null) {
				for (Item item : items) {
					item.setMedorder(medorder);
				}
			}
			medorder.setEncounter(encounter);
			medOrderRepository.save(medorder);
			return medorder;
		}
		return null;
	}

	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<MedOrder> getAllMedOrderByEncounterId(int id) {
		return medOrderRepository.getAllMedOrderByEncounterId(id);
	}

	public MedOrder updateMedOrder(int id, MedOrder medorder) {
		MedOrder existingmedorder = getMedOrderById(id);
		if (existingmedorder != null) {
			medOrderRepository.save(medorder);
			return medorder;
		}
		return null;
	}

	public boolean deleteMedorderById(int id) {
		MedOrder medorder = getMedOrderById(id);
		if (medorder != null) {
			medOrderRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
