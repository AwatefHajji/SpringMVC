package com.awatef.codingdojo.dojo_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awatef.codingdojo.dojo_ninjas.models.NinjaModel;



@Repository
public interface NinjaRepository extends CrudRepository<NinjaModel, Long> {
	List<NinjaModel> findAll();

}
