package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepository encounterRepository;

	@Autowired
	private PersonDao persondao;

	@Autowired
	private BranchDao branchdao;

	public Encounter saveEncounter(int personid, int branchid, Encounter encounter) {
		Person person = persondao.getPersonById(personid);
		Branch branch = branchdao.getBrancByID(branchid);
		if (person != null && branch != null) {
			encounter.setPerson(person);
			encounter.setBranch(branch);
			encounterRepository.save(encounter);
			return encounter;
		}
		return null;
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Encounter> getAllEncountersByPersonAndBranchId(int branchid, int personid) {
		return encounterRepository.getAllEncountersByPersonAndBranchId(branchid, personid);
	}

	public Encounter updateEncounter(int id, Encounter encounter) {
		Encounter exestingencounter = getEncounterById(id);
		if (exestingencounter != null) {
			encounterRepository.save(encounter);
			return encounter;
		}
		return null;
	}

	public boolean deleteEncounterById(int id) {
		Encounter encounter = getEncounterById(id);
		if (encounter != null) {
			encounterRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
