package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(@RequestBody Person person) {
		return personRepository.save(person);

	}

	public Person getPersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	public Person updatePerson(int id, Person person) {
		Person existingperson = getPersonById(id);
		if (existingperson != null) {
			personRepository.save(person);
			return person;
		}
		return null;
	}

	public boolean deletePerson(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			personRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
