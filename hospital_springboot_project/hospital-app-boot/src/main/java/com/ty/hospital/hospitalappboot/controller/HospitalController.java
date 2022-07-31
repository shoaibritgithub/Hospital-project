package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.service.HospitalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@ApiOperation(value = "save the Hospital",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital is saved"),
		@ApiResponse(code = 405, message = "bad request,not proper Hospital data")
	})
	@PostMapping("/hospital")
	public Hospital saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@ApiOperation(value = "get the hospital by id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the hospital"),
		@ApiResponse(code = 405, message = "bad request,invalid hospital id")
	})
	@GetMapping("/hospital")
	public Hospital getHospitalById(@RequestParam int id) {
		return hospitalService.getHospitalById(id);
	}
	
	@ApiOperation(value = "get all the Hospital",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got all the hospital"),
		@ApiResponse(code = 405, message = "bad request,please check the url that you entered")
	})
	@GetMapping("/allhospital")
	public List<Hospital> getAllHospital() {

		return hospitalService.getAllHospital();
	}
	
	@ApiOperation(value = "update the Hospital By id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital is updated"),
		@ApiResponse(code = 405, message = "bad request,invalid hospital id,not proper Item data")
	})
	@PutMapping("/hospital")
	public Hospital updateHospital(@RequestParam int id, @RequestBody Hospital hospital) {
		return hospitalService.updateHospitalById(id, hospital);
	}

	@ApiOperation(value = "delete the Hospital",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200, message = "hospital is deleted"),
		@ApiResponse(code = 405, message = "bad request,invalid hospital id")
	})
	@DeleteMapping("/hospital")
	public void deleteHospitalById(@RequestParam int id) {
		hospitalService.deleteHospitalById(id);
	}
}
