package com.awatef.codingdojo.dojo_ninjas.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.awatef.codingdojo.dojo_ninjas.models.DojoModel;
import com.awatef.codingdojo.dojo_ninjas.models.NinjaModel;
import com.awatef.codingdojo.dojo_ninjas.services.DojoService;
import com.awatef.codingdojo.dojo_ninjas.services.NinjaService;

import jakarta.validation.Valid;



@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") NinjaModel ninja , Model model) {
		ArrayList<DojoModel> allDojos = (ArrayList<DojoModel>) dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
        return "new_ninja.jsp";}
    // action route to add an ninja
    @PostMapping("/ninjas")
    public String addexpense(@Valid @ModelAttribute("ninja") NinjaModel ninja, 
    		BindingResult result) {
    	  if (result.hasErrors()) {
              return "new_ninja.jsp";
          } else {
        	  ninjaService.createNinja(ninja);
              return "redirect:/";
          }
    	
    }
	
}
