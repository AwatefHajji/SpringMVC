package com.awatef.codingdojo.dojo_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.awatef.codingdojo.dojo_ninjas.models.DojoModel;
import com.awatef.codingdojo.dojo_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	// adding the dojo repository as a dependency
	
	private final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }
	 // returns all  expenses
    public List<DojoModel> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a dojo
    public DojoModel createDojo(DojoModel d) {
        return dojoRepository.save(d);
    }
    // find on dojo by id
    public DojoModel findDojo(Long id) {
        Optional<DojoModel> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    // edit dojo
    public DojoModel updateDojo(DojoModel d) {
        return dojoRepository.save(d);
    }
    // Delete a dojo
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
}
