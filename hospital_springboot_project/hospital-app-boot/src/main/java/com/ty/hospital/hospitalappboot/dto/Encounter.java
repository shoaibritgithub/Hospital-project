package com.ty.hospital.hospitalappboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason;
	@CreationTimestamp
	private LocalDateTime date_of_admit;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;

	@OneToMany(mappedBy = "encounter")
	private List<MedOrder> medorders;

	public int getId() {
		return id;
	}

	public List<MedOrder> getMedorders() {
		return medorders;
	}

	public void setMedorders(List<MedOrder> medorders) {
		this.medorders = medorders;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getDate_of_admit() {
		return date_of_admit;
	}

	public void setDate_of_admit(LocalDateTime date_of_admit) {
		this.date_of_admit = date_of_admit;
	}

	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@JsonIgnore
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
