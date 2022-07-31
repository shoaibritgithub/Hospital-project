package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;
@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitaldao;
	
	public Hospital saveHospital(Hospital hospital)
	{
		Hospital hospital1 = hospitaldao.saveHospital(hospital);
		if(hospital==null)
		{
			throw new IdNotFoundException();
		}
		return hospital1;
	}
	
	public Hospital getHospitalById(int id)
	{
		Hospital hospital = hospitaldao.getHospitalById(id);
		if(hospital==null)
		{
			throw new IdNotFoundException();
		}
		return hospital;
	}
	
	public List<Hospital> getAllHospital()
	{
		List<Hospital> hospitals = hospitaldao.getAllHospitalById();
		if(hospitals.isEmpty())
		{
			throw new IdNotFoundException();
		}
		return hospitals;
	}
	
	public Hospital updateHospitalById(int id,Hospital hospital)
	{
		Hospital hospital1 = hospitaldao.updateHospital(id, hospital);
		if(hospital1==null)
		{
			throw new IdNotFoundException();
		}
		return hospital;
	}
	
	public boolean deleteHospitalById(int id)
	{
		boolean hospital = hospitaldao.deleteHospitalbyId(id);
		if(hospital==false)
		{
			throw new IdNotFoundException();
		}
		return true;
	}
	
}
