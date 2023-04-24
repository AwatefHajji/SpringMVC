package com.awatef.codingdojo.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.awatef.codingdojo.burgertracker.models.BurgerModel;
import com.awatef.codingdojo.burgertracker.repositories.BurgerRepository;


@Service
public class BurgerService {
    // adding the burger repository as a dependency
    private final BurgerRepository burgerRepository;
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    // returns all  burgers
    public List<BurgerModel> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a burger
    public BurgerModel createBurger(BurgerModel b) {
        return burgerRepository.save(b);
    }
    // find on burger by id
    public BurgerModel findBurger(Long id) {
        Optional<BurgerModel> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    // edit burger
    public BurgerModel updateBurger(BurgerModel b) {
        return burgerRepository.save(b);
    }
    // Delete a burger
    public void deleteBurger(Long id) {
    	burgerRepository.deleteById(id);
    }
    
    
}
