package com.benin.sprigbootpostgresql.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(generator="employees_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(
			name = "employees_id_seq",
			sequenceName="employees_id_seq",
			allocationSize=1
			)
	private long id;
	
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname; 
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=Pet.class)
	private List<Pet> pets; 
	
	public Employee( String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public Employee() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Pet> getPets() {
		if(this.pets == null) {
			this.pets = new ArrayList<Pet>();
		}
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
	

}
