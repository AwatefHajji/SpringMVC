package com.awatef.codingdojo.burgertracker.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.awatef.codingdojo.burgertracker.models.BurgerModel;
import com.awatef.codingdojo.burgertracker.services.BurgerService;

import jakarta.validation.Valid;


@Controller
public class BurgerController {
	// ==dependency injection to make burgerService available in our controller
	@Autowired
	BurgerService burgerService;
    @GetMapping("/burgers")
    public String newBurger(@ModelAttribute("burger") BurgerModel burger , Model model) {
		ArrayList<BurgerModel> allBurgers = (ArrayList<BurgerModel>) burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
        return "index.jsp";}
    
    @PostMapping("/handelForm")
    public String create(@Valid @ModelAttribute("burger") BurgerModel burger, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	burgerService.createBurger(burger);
            return "redirect:/burgers";
        }
    }
    // === display route to edit a burger
    @GetMapping("/burgers/edit/{id}")
    public String update(@PathVariable("id") Long id , Model model) {
    	BurgerModel burger = burgerService.findBurger(id);
    	model.addAttribute("burger", burger);
    	return "edit.jsp";
    }
    // Action route to update a burger 
    @PutMapping("/burgers/{id}")
    public String update(@Valid @ModelAttribute("burger") BurgerModel burger, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	burgerService.updateBurger(burger);
            return "redirect:/burgers";
        }
    }
    // Action route to delete a burger
    @DeleteMapping("/burgers/delete/{id}")
    public String distroyBurger(@PathVariable("id") Long id) {
    	burgerService.deleteBurger(id);
    	return "redirect:/burgers";
    }
    
    
    
    
    
    
}
