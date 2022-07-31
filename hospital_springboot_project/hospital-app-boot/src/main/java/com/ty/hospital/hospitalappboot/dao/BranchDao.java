package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private HospitalDao hospitaldao;

	public Branch saveBranchByHospitalId(int id, Branch branch) {
		Hospital hospital = hospitaldao.getHospitalById(id);

		if (hospital != null) {
			branch.setHospital(hospital);
			branchRepository.save(branch);
			return branch;
		}
		return null;
	}

	public Branch getBrancByID(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Branch> getAllBranchByHospitalId(int id) {
		return branchRepository.getAllBranchByHospitalId(id);
	}

	public Branch updateBranch(int id, Branch branch) {
		Branch exestingbranch = getBrancByID(id);
		if (exestingbranch != null) {
			branchRepository.save(branch);
			return branch;
		}
		return null;
	}

	public boolean deleteBranchById(int id) {
		Branch branch = getBrancByID(id);
		if (branch != null) {
			branchRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
