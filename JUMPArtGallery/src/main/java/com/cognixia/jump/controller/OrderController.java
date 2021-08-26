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
import com.cognixia.jump.model.Order;
import com.cognixia.jump.repository.OrderRepository;

@RequestMapping("/api")
@RestController
public class OrderController {
	
	@Autowired
	OrderRepository repo;
	
	@GetMapping("/order")
	public List<Order> getOrders() {
		
		return repo.findAll();
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		
		order.setId(-1L);

		Order created = repo.save(order);
		
		return ResponseEntity.status(201).body(created);
	}
	
	
	@PutMapping("/order")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) throws ResourceNotFoundException {
		
		if(repo.existsById(order.getId())) {
			
			Order updated = repo.save(order);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		throw new ResourceNotFoundException("Order with id = " + order.getId() + " was not found");
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<?> deleteCustomer(@RequestBody Long id) throws ResourceNotFoundException {
		
		if(repo.existsById(id)) {
			
			repo.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted order with id = " + id);
		}
		
		throw new ResourceNotFoundException("Order with id = " + id + " was not found. Wasn't deleted.");
		
	}

}
