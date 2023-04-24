package com.awatef.codingdojo.travels.controllers;

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


import com.awatef.codingdojo.travels.models.ExpenseModel;
import com.awatef.codingdojo.travels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	// ==dependency injection to make burgerService available in our controller
	@Autowired
	ExpenseService expenseService;
    @GetMapping("/")
    public String newExpense(@ModelAttribute("expense") ExpenseModel expense , Model model) {
		ArrayList<ExpenseModel> allExpenses = (ArrayList<ExpenseModel>) expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
        return "index.jsp";}
    // action route to add an expense
    @PostMapping("/expenses")
    public String addexpense(@Valid @ModelAttribute("expense") ExpenseModel expense, 
    		BindingResult result) {
    	  if (result.hasErrors()) {
              return "index.jsp";
          } else {
        	  expenseService.createExpense(expense);
              return "redirect:/";
          }
    	
    }
	// ===display route to show Expense
	@GetMapping("/expenses/{expenseId}")
	public String showExpense(@PathVariable("expenseId") Long expenseId, Model model) {
		
		ExpenseModel expense = expenseService.findExpense(expenseId);
		
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
    // === display route to edit an expense
    @GetMapping("/expenses/edit/{id}")
    public String update(@PathVariable("id") Long id , Model model) {
    	ExpenseModel expense = expenseService.findExpense(id);
    	model.addAttribute("expense", expense);
    	return "edit.jsp";
    }
    // Action route to update an expense 
    @PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") ExpenseModel expense, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	expenseService.updateExpense(expense);
            return "redirect:/";
        }
    }
    // Action route to delete a burger
    @DeleteMapping("/expenses/delete/{id}")
    public String distroyExpense(@PathVariable("id") Long id) {
    	expenseService.deleteExpense(id);
    	return "redirect:/";
    }

}
