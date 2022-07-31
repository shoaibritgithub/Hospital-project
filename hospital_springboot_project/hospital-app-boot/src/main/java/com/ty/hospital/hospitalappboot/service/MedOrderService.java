package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.MedOrderDao;
import com.ty.hospital.hospitalappboot.dto.MedOrder;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;
@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao medorderdao;

	public MedOrder saveMedOrderByEncounterId(int id, MedOrder medorder) {
		MedOrder medorder1 = medorderdao.saveMedOrder(id, medorder);
		if (medorder1 == null) {
			throw new IdNotFoundException();
		}
		return medorder1;
	}

	public MedOrder getMedOrderById(int id) {
		MedOrder medorder = medorderdao.getMedOrderById(id);
		if (medorder == null) {
			throw new IdNotFoundException();
		}
		return medorder;
	}

	public List<MedOrder> getAllMedOrderByEncounterId(int id) {
		List<MedOrder> medorders = medorderdao.getAllMedOrderByEncounterId(id);
		if (medorders.isEmpty()) {
			throw new IdNotFoundException();
		}
		return medorders;
	}

	public MedOrder updMedOrderById(int id, MedOrder medorder) {
		MedOrder medorder1 = medorderdao.updateMedOrder(id, medorder);
		if (medorder1 == null) {
			throw new IdNotFoundException();
		}
		return medorder1;
	}

	public boolean deleteMedOrderByid(int id) {
		boolean medorder = medorderdao.deleteMedorderById(id);
		if (medorder == false) {
			throw new IdNotFoundException();
		}
		return true;
	}

}
