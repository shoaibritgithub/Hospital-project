package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService personservice;
	
	@ApiOperation(value = "save the person details",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "person saved"),
		@ApiResponse(code = 405, message = "bad request,not proper person data")
	})
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {
		return personservice.savePerson(person);
	}
	
	@ApiOperation(value = "get the person details by id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the person by id"),
		@ApiResponse(code = 405, message = "bad request,invalid person id")
	})
	@GetMapping("/person")
	public Person getPerson(@RequestParam int id) {
		return personservice.getPersonById(id);	
	}
	
	@ApiOperation(value = "get All the person",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got all the person"),
		@ApiResponse(code = 405, message = "bad request,please check the url you entered")
	})
	@GetMapping("/allperson")
	public List<Person> getAllPerson() {
		return personservice.getAllPerson();
	}
	
	@ApiOperation(value = "update the person details bvy id",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "person detail updated"),
		@ApiResponse(code = 405, message = "bad request,invalid person id,not proper person data")
	})
	@PutMapping("/person")
	public Person updatePerson(@RequestParam int id, @RequestBody Person person) {
		return personservice.updatePersonByid(id, person);
	}
	
	@ApiOperation(value = "delete the person by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "person is deleted"),
		@ApiResponse(code = 405, message = "bad request,invalid person id")
	})
	@DeleteMapping("/person")
	public void deletePerson(@RequestParam int id) {
		personservice.deletePersonById(id);
	}
}
