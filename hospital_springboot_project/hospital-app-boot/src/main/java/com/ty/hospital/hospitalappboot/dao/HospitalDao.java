package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {

		List<Branch> branches = hospital.getBranches();
		if (branches != null) {
			for (Branch branch : branches) {
				branch.setHospital(hospital);
			}
		}
		return hospitalRepository.save(hospital);
	}

	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = hospitalRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Hospital exestinghospital = getHospitalById(id);
		if (exestinghospital != null) {
			hospitalRepository.save(hospital);
			return hospital;
		}
		return null;
	}

	public List<Hospital> getAllHospitalById() {
		return hospitalRepository.findAll();
	}

	public boolean deleteHospitalbyId(int id) {
		Hospital hospital = getHospitalById(id);
		if (hospital != null) {
			hospitalRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
