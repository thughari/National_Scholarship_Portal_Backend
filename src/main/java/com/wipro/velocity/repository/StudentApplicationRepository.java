package com.wipro.velocity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.model.StudentApplication;

public interface StudentApplicationRepository extends MongoRepository<StudentApplication, String> {


	List<StudentApplication> findByStatus(Boolean status);

	
	
	public Optional<StudentApplication> findByAadhar(String aadhar);



	public Optional<StudentApplication> deleteByAadhar(String aadhar);

}
