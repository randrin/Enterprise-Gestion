package com.enterprise.gestion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.gestion.model.Customer;
import com.enterprise.gestion.repository.CustomerRepository;
import com.enterprise.gestion.utils.EmployesUtils;


@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomer() {
		System.out.println("################# getAllCustomer ...");
		List<Customer> listCustomer = new ArrayList<>();
		Iterable<Customer> customers = customerRepository.findAll();
		
		for (Customer cust : customers) {
			listCustomer.add(cust);
		}
		return listCustomer;
	}
	
	@PostMapping(value = "/postcustomer")
	public Customer postCustomer (@RequestBody Customer customer) {
		System.out.println("################# postCustomer ...");
		System.out.println("################# customer.getFirstName() ... " +customer.getFirstName());
		System.out.println("################# customer.getFirstName() ... " +customer.getLastName());
		System.out.println("################# customer.getDepartment() ... " +customer.getDepartment());
		System.out.println("################# customer.getGender() ... " +customer.getGender());
		System.out.println("################# customer.getEmail() ... " +customer.getEmail());
		System.out.println("################# customer.getPhone() ... " +customer.getPhoneNumber());
		customer.setMatricule(EmployesUtils.generateMatricule(customer.getFirstName(), customer.getLastName(), customer.getNaissance(), customer.getDepartment()));
		customerRepository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getDepartment(),
				customer.getNaissance(), customer.getMatricule(), customer.getGender(), customer.getEmail(), customer.getPhoneNumber()));
		return customer;
	}
	
//	@GetMapping(value = "/findbylastname/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Customer> findByLastName (@PathVariable String lastName) {
//		List<Customer> listCustomer = customerRepository.firstByLastName(lastName);
//		return listCustomer;
//	}
	
	@DeleteMapping(value = "/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
	
	/**
	 * @return the customerRepository
	 */
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	/**
	 * @param customerRepository the customerRepository to set
	 */
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
}
