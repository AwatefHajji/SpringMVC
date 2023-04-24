package com.awatef.codingdojo.burgertracker.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awatef.codingdojo.burgertracker.models.BurgerModel;
@Repository
public interface BurgerRepository extends CrudRepository<BurgerModel, Long> {
    // this method retrieves all the books from the database
    List<BurgerModel> findAll();

}
