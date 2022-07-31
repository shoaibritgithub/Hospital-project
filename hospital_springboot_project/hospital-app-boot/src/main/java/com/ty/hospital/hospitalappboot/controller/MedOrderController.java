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
import com.ty.hospital.hospitalappboot.dto.MedOrder;
import com.ty.hospital.hospitalappboot.service.MedOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService medorderservice;
	
	@ApiOperation(value = "save the medOrder details by Encounter Id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "medorder saved"),
		@ApiResponse(code = 405, message = "bad request,not proper medorder data")
	})
	@PostMapping("/encounter/{encounterid}/medorder")
	public MedOrder saveMedOrder(@PathVariable(name = "encounterid") int id, @RequestBody MedOrder medorder) {
		return medorderservice.saveMedOrderByEncounterId(id, medorder);
	}
	
	@ApiOperation(value = "get the medorder by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the medorder"),
		@ApiResponse(code = 405, message = "bad request,invalid medorder ID")
	})
	@GetMapping("/medorder")
	public MedOrder getMedOrderById(@RequestParam int id) {
		return medorderservice.getMedOrderById(id);
	}
	
	@ApiOperation(value = "get the medorder by Encounter ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got all the medorder by Encounter ID"),
		@ApiResponse(code = 405, message = "bad request,invalid medorder encounter ID")
	})
	@GetMapping("/medorder/encounter")
	public List<MedOrder> getAllMedOrderByEncounterId(@RequestParam int id) {
		return medorderservice.getAllMedOrderByEncounterId(id);
	}

	@ApiOperation(value = "update the medorder by its id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "midorder is updated"),
		@ApiResponse(code = 405, message = "bad request,invalid medorder id,not proper medorder data")
	})
	@PutMapping("/medorder")
	public MedOrder updateMedOrder(@RequestParam int id, @RequestBody MedOrder medorder) {
		return medorderservice.updMedOrderById(id, medorder);
	}
	
	@ApiOperation(value = "delete the medorder by its id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "midorder is deleted"),
		@ApiResponse(code = 405, message = "bad request,invalid medorder id")
	})
	@DeleteMapping("/medorder")
	public void deleteMedOrder(int id) {
		medorderservice.deleteMedOrderByid(id);
	}

}
