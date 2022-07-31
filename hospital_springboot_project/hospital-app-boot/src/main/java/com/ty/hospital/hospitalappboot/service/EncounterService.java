package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.EncounterDao;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;
@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterdao;

	public Encounter saveEncounter(int personid, int branchid, Encounter encounter) {
		Encounter encounter1 = encounterdao.saveEncounter(personid, branchid, encounter);
		if (encounter1 == null) {
			throw new IdNotFoundException();
		}
		return encounter1;
	}

	public Encounter getEncounterById(int id) {
		Encounter encounter = encounterdao.getEncounterById(id);
		if (encounter == null) {
			throw new IdNotFoundException();
		}
		return encounter;
	}

	public List<Encounter> getAllEncounterByPersonandBranchId(int branchid, int personid) {
		List<Encounter> encounters = encounterdao.getAllEncountersByPersonAndBranchId(branchid, personid);
		if (encounters.isEmpty()) {
			throw new IdNotFoundException();
		}
		return encounters;
	}

	public Encounter updateEncounterById(int id, Encounter encounter) {
		Encounter encounter1 = encounterdao.updateEncounter(id, encounter);
		if (encounter1 == null) {
			throw new IdNotFoundException();
		}
		return encounter1;
	}

	public boolean deleteEncounterById(int id) {
		boolean encounter = encounterdao.deleteEncounterById(id);
		if (encounter == false) {
			throw new IdNotFoundException();
		}
		return true;
	}
}
