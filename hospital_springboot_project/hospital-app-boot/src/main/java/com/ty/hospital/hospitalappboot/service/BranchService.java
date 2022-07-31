package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;

@Service
public class BranchService {
	
	@Autowired
	private BranchDao branchdao;
	
	@Autowired
	private HospitalDao hospitaldao;
	
	public Branch saveBranchByHospitalId(int id,Branch branch)
	{
		Branch branch1  = branchdao.saveBranchByHospitalId(id, branch);
		if(branch1==null)
		{
			throw new IdNotFoundException();
		}
		return branch1;
	}
	
	public Branch getBranchById(int id)
	{
		Branch branch = branchdao.getBrancByID(id);
		if(branch==null)
		{
			throw new IdNotFoundException();
		}
		return branch;
	}
	
	public List<Branch> getAllBranchByHospitalId(int id)
	{
		List<Branch> branches = branchdao.getAllBranchByHospitalId(id);
		if(branches.isEmpty())
		{
			throw new IdNotFoundException();
		}
		return branches;
	}
	
	public Branch updateBranchById(int id, Branch branch)
	{
		Branch branch1 = branchdao.updateBranch(id, branch);
		if(branch1==null)
		{
			throw new IdNotFoundException();
		}
		return branch1;
	}
	
	public boolean deleteBranchById(int id)
	{
		boolean branch = branchdao.deleteBranchById(id);
		if(branch==false)
		{
			throw new IdNotFoundException();
		}
		return true;
	}
}
