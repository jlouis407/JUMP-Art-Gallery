package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repository.CustomerRepository;

@RequestMapping("/api")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/customer")
	public List<Customer> getCustomers() {
		
		return repo.findAll();
	}
	
	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		
		customer.setId(-1L);

		Customer created = repo.save(customer);
		
		return ResponseEntity.status(201).body(created);
	}
	
	
	@PutMapping("/customer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws ResourceNotFoundException {
		
		if(repo.existsById(customer.getId())) {
			
			Customer updated = repo.save(customer);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		throw new ResourceNotFoundException("Customer with id = " + customer.getId() + " was not found");
	}
	
	@DeleteMapping("/customer")
	public ResponseEntity<?> deleteCustomer(@RequestBody Long id) throws ResourceNotFoundException {
		
		if(repo.existsById(id)) {
			
			repo.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted customer with id = " + id);
		}
		
		throw new ResourceNotFoundException("Customer with id = " + id + " was not found. Wasn't deleted.");
		
	}

}
