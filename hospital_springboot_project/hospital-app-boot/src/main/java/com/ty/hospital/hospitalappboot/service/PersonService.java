package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonDao persondao;

	public Person savePerson(Person person) {
		Person person1 = persondao.savePerson(person);
		if (person1 == null) {
			throw new IdNotFoundException();
		}
		return person1;
	}

	public Person getPersonById(int id) {
		Person person = persondao.getPersonById(id);
		if (person == null) {
			throw new IdNotFoundException();
		}
		return person;
	}

	public List<Person> getAllPerson() {
		List<Person> persons = persondao.getAllPerson();
		if (persons.isEmpty()) {
			throw new IdNotFoundException();
		}
		return persons;
	}

	public Person updatePersonByid(int id, Person person) {
		Person person1 = persondao.updatePerson(id, person);
		if (person1 == null) {
			throw new IdNotFoundException();
		}
		return person1;
	}

	public boolean deletePersonById(int id) {
		boolean person = persondao.deletePerson(id);
		if (person == false) {
			throw new IdNotFoundException();
		}
		return true;
	}
}
