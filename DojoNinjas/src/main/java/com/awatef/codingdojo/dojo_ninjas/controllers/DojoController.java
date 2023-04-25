package com.awatef.codingdojo.dojo_ninjas.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.awatef.codingdojo.dojo_ninjas.models.DojoModel;
import com.awatef.codingdojo.dojo_ninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") DojoModel dojo,Model model) {
		List<DojoModel> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
        return "new_dojo.jsp";}
    
    // action route to add an dojo
    @PostMapping("/dojos")
    public String addexpense(@Valid @ModelAttribute("dojo") DojoModel dojo, 
    		BindingResult result) {
    	  if (result.hasErrors()) {
              return "new_dojo.jsp";
          } else {
        	  dojoService.createDojo(dojo);
              return "redirect:/";
          }
    	
    }
    //display route to show dojo his ninjas
    @GetMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id,Model model) {
    	DojoModel dojo = dojoService.findDojo(id);
    	model.addAttribute("dojo",dojo);
    	return"show.jsp";
    }

}
