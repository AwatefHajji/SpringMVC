package com.awatef.codingdojo.burgertracker.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    
}
