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

import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@ApiOperation(value = "save the branch by Hospital id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch is saved"),
		@ApiResponse(code = 405, message = "bad request,not proper Branch data")
	})
	@PostMapping("/hospital/{hospitalid}/branch")
	public Branch saveBranchByHospitalId(@PathVariable(name = "hospitalid") int id, @RequestBody Branch branch) {
		return branchService.saveBranchByHospitalId(id, branch);
	}
	
	@ApiOperation(value = "get the branch by id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the branch"),
		@ApiResponse(code = 405, message = "bad request,invalid branch id")
	})
	@GetMapping("/branch")
	public Branch getBranchById(@RequestParam int id) {
		return branchService.getBranchById(id);
	}

	@ApiOperation(value = "get all the branch by hospital id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the all branch"),
		@ApiResponse(code = 405, message = "bad request,invalid hospital id")
	})
	@GetMapping("/branch/hospital")
	public List<Branch> getAllBranchByHospitalId(@RequestParam int id) {
		return branchService.getAllBranchByHospitalId(id);
	}

	@ApiOperation(value = "update the branch by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "branch is updated"),
		@ApiResponse(code = 405, message = "bad request,invalid branch id,not proper Branch data")
	})
	@PutMapping("/branch")
	public Branch updateBranch(@RequestParam int id, @RequestBody Branch branch) {
		return branchService.updateBranchById(id, branch);
	}
	
	@ApiOperation(value = "delete the branch by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "branch is deleted"),
		@ApiResponse(code = 405, message = "bad request,invalid branch id")
	})
	@DeleteMapping("/branch")
	public void deleteBranchById(@RequestParam int id) {
		branchService.deleteBranchById(id);
	}
}
