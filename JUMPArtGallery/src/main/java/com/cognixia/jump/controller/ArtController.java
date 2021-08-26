package com.cognixia.jump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Art;
import com.cognixia.jump.repository.ArtRepository;

@RequestMapping("/api")
@RestController
public class ArtController {
	
	@Autowired
	ArtRepository repo;
	
	@GetMapping("/art/{id}") 
	public Art getArt(@PathVariable long id) throws ResourceNotFoundException {
		
		if(repo.existsById(id)) {
			// return the account
			
			return repo.findById(id).get();
		}
		
		// if it doesn't exist, return an exception
		throw new ResourceNotFoundException("Art with id = " + id + " was not found");
	}
	
}
