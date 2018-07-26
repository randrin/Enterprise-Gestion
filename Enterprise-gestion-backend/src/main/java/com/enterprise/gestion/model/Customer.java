package com.enterprise.gestion.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -1615251736218121237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstNameCust")
	private String firstName;
	
	@Column(name = "lastNameCust")
	private String lastName;
	
	@Column(name = "departmentCust")
	private String department;
	
	@Column(name = "genderCust")
	private String gender;
	
	@Column(name = "emailCust")
	private String email;
	
	@Column(name = "naissanceCust")
	private Date naissance;
	
	@Column(name = "phoneCust")
	private String phoneNumber;
	
	@Column(name = "matriculeCust")
	private String matricule;
	
	public Customer() {}
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param roleCustomer
	 * @param naissance
	 * @param matricule
	 * @param gender
	 * @param email
	 * @param phoneNumber
	 */
	public Customer(String firstName, String lastName, String department, Date naissance, String matricule, 
			String gender, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.naissance = naissance;
		this.matricule = matricule;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the departmentCustomer
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * @param departmentCustomer the departmentCustomer to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the naissance
	 */
	public Date getNaissance() {
		return naissance;
	}


	/**
	 * @param naissance the naissance to set
	 */
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}


	/**
	 * @return the phone
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}


	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}

