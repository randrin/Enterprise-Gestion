package com.enterprise.gestion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.enterprise.gestion.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{

	//public List<Customer> firstByLastName(String lastName);
}
