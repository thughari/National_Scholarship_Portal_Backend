package com.wipro.velocity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.model.NodalModel;

public interface NodalRepository extends MongoRepository<NodalModel, String> {

	public Optional<NodalModel> findByNodalId(String id);

}
