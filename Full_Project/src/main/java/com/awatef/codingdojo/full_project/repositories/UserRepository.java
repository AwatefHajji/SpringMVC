package com.awatef.codingdojo.full_project.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awatef.codingdojo.full_project.models.UserModel;
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
	List<UserModel> findAll();

	Optional<UserModel> findByEmail(String email);
}
