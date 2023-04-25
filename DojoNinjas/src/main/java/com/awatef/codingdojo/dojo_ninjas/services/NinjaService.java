package com.awatef.codingdojo.dojo_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.awatef.codingdojo.dojo_ninjas.models.NinjaModel;
import com.awatef.codingdojo.dojo_ninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
	        this.ninjaRepository = ninjaRepository;
	    }
	 // returns all  ninjas
    public List<NinjaModel> allNinjas() {
        return ninjaRepository.findAll();
    }
    // create a ninja
    public NinjaModel createNinja(NinjaModel n) {
        return ninjaRepository.save(n);
    }
    // find on ninja by id
    public NinjaModel findNinja(Long id) {
        Optional<NinjaModel> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    // edit ninja
    public NinjaModel updateNinja(NinjaModel n) {
        return ninjaRepository.save(n);
    }
    // Delete a ninja
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
}
