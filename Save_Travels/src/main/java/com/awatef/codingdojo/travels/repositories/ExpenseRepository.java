package com.awatef.codingdojo.travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awatef.codingdojo.travels.models.ExpenseModel;
@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseModel, Long> {
	List<ExpenseModel> findAll();

}
