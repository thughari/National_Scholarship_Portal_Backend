package com.wipro.velocity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wipro.velocity.model.StudentModel;

//@RepositoryRestResource(collectionResourceRel = "studentregisterdata",path = "studentregisterdata")
public interface StudentRepository extends MongoRepository<StudentModel,String> {
	
	public Optional<StudentModel> findByEmail(String email);

	public Optional<StudentModel> findByAadhar(String aadhar);


}
