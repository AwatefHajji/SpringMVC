package com.awatef.codingdojo.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.awatef.codingdojo.travels.models.ExpenseModel;
import com.awatef.codingdojo.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// adding the expense repository as a dependency
	
	private final ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository) {
	        this.expenseRepository = expenseRepository;
	    }
	 // returns all  expenses
    public List<ExpenseModel> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a expense
    public ExpenseModel createExpense(ExpenseModel b) {
        return expenseRepository.save(b);
    }
    // find on expense by id
    public ExpenseModel findExpense(Long id) {
        Optional<ExpenseModel> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // edit expense
    public ExpenseModel updateExpense(ExpenseModel b) {
        return expenseRepository.save(b);
    }
    // Delete a expense
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }

}
