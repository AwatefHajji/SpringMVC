package com.awatef.codingdojo.burgertracker.services;

import java.util.List;

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
    // creates a book
    public BurgerModel createBurger(BurgerModel b) {
        return burgerRepository.save(b);
    }
    
}
