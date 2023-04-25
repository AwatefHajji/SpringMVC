package com.awatef.codingdojo.dojo_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awatef.codingdojo.dojo_ninjas.models.DojoModel;



@Repository
public interface DojoRepository extends CrudRepository<DojoModel, Long> {
	List<DojoModel> findAll();

}
