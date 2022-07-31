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


import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService encounterService;
	
	@ApiOperation(value = "save the encounter by Branch_id and person_id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter is saved"),
		@ApiResponse(code = 405, message = "bad request,not proper Encounter data")
	})
	@PostMapping("/person/{personid}/branch/{branchid}/encounter")
	public Encounter SaveEncounter(@PathVariable(name = "personid") int id1, @PathVariable(name = "branchid") int id2,
			@RequestBody Encounter encounter) {
		return encounterService.saveEncounter(id1, id2, encounter);
	}
	@ApiOperation(value = "get the encounter by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the encounter"),
		@ApiResponse(code = 405, message = "bad request,invalid encounter id")
	})
	@GetMapping("/encounter")
	public Encounter getEncounter(@RequestParam int id) {
		return encounterService.getEncounterById(id);
	}

	@ApiOperation(value = "get all the encounter by person_id and branch_id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got all the encounter"),
		@ApiResponse(code = 405, message = "bad request,invalid personr or branch ID")
	})
	@GetMapping("/encounter/branch/{branchid}/person/{personid}")
	public List<Encounter> getAllEncountersByHospitalAndBranchId(@PathVariable int branchid,
			@PathVariable int personid) {
		return encounterService.getAllEncounterByPersonandBranchId(branchid, personid);
	}
	 
	@ApiOperation(value = "update the encounter by id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter is updated"),
		@ApiResponse(code = 405, message = "bad request,invalid encounter id,not proper encounter data")
	})
	@PutMapping("/encounter")
	public Encounter updateEncounter(@RequestParam int id, @RequestBody Encounter encounter) {
		return encounterService.updateEncounterById(id, encounter);
	}
	
	@ApiOperation(value = "delete the encounter by id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter is deleted"),
		@ApiResponse(code = 405, message = "bad request,invalid encounter id")
	})
	@DeleteMapping("/encounter")
	public void deleteEncounterById(@RequestBody int id) {
		encounterService.deleteEncounterById(id);
	}
}
