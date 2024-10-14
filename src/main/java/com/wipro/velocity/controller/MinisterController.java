package com.wipro.velocity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.model.InstituteModel;
import com.wipro.velocity.model.MinistryModel;
import com.wipro.velocity.model.StudentApplication;
import com.wipro.velocity.model.StudentModel;
import com.wipro.velocity.repository.InstituteRepository;
import com.wipro.velocity.repository.MinistryRepository;
import com.wipro.velocity.repository.StudentApplicationRepository;
import com.wipro.velocity.repository.StudentRepository;


@RequestMapping("ministry")
@RestController
@CrossOrigin(origins = "https://thughari.github.io")
public class MinisterController {


	@Autowired
	private StudentRepository stuRep;

	@Autowired
	private StudentApplicationRepository stuAppRepo;

	@Autowired
	private InstituteRepository instRepo;

	@Autowired
	private MinistryRepository miniRepo;

	@PostMapping("/loginministry")
	public Boolean loginMinister(@Validated @RequestBody MinistryModel min) throws ResourceNotFoundException {

		Boolean isLogin=false;
		String id=min.getMinistryId();
		String password=min.getPassword();

		MinistryModel minister = miniRepo.findByMinistryId(id).orElseThrow(() ->
		new ResourceNotFoundException("Unknown Ministry"));

		if(id.equals(minister.getMinistryId()) && password.equals(minister.getPassword()))
		{
			isLogin=true;
		}
		return isLogin;
	}




	@GetMapping("/Studentapplicationministry")
	public List<StudentApplication> getapprovedApplications(){
		return /*(List<StudentApplication>)*/stuAppRepo.findByStatus(true);
	}


	@PutMapping("/finalapproval/{id}")
	  public ResponseEntity<StudentApplication> updateFinalStatus(@PathVariable(value="id") String aId,
	      @Validated @RequestBody StudentApplication s) throws ResourceNotFoundException
	  {
	    StudentApplication application=stuAppRepo.findById(aId).
	        orElseThrow(() -> new ResourceNotFoundException
	            ("Student Not Found for this Id: " +aId));


	    application.setFinalStatus(true);
	    
	    updateStudentStatus(aId, true);
	    

	    StudentApplication updatedFinalStatus=stuAppRepo.save(application);

	    return ResponseEntity.ok(updatedFinalStatus);
	  }
	  
	  public ResponseEntity<StudentModel> updateStudentStatus(@PathVariable(value="id") String aId,
	      @Validated @RequestBody boolean b) throws ResourceNotFoundException
	  {
	    StudentModel application=stuRep.findById(aId).
	        orElseThrow(() -> new ResourceNotFoundException
	            ("Student Not Found for this Id: " +aId));


	    application.setStatus(true);
	    
	    

	    StudentModel updatedFinalStatus=stuRep.save(application);

	    return ResponseEntity.ok(updatedFinalStatus);
	  }


	@PutMapping("/institutefinalapproval/{instCode}")
	public ResponseEntity<InstituteModel> updateFinalInstituteStatus(@PathVariable(value="instCode") String instCode,
			@Validated @RequestBody InstituteModel s) throws ResourceNotFoundException
	{
		InstituteModel application=instRepo.findById(instCode).
				orElseThrow(() -> new ResourceNotFoundException
						("Student Not Found for this Id: " +instCode));


		application.setFinalStatus(true);

		updateInstituteStatus(instCode, true);


		InstituteModel updatedFinalStatus=instRepo.save(application);

		return ResponseEntity.ok(updatedFinalStatus);
	}

	public ResponseEntity<InstituteModel> updateInstituteStatus(@PathVariable(value="instCode") String aId,
			@Validated @RequestBody boolean b) throws ResourceNotFoundException
	{
		InstituteModel application=instRepo.findById(aId).
				orElseThrow(() -> new ResourceNotFoundException
						("Student Not Found for this Id: " +aId));


		application.setStatus(true);



		InstituteModel updatedFinalStatus=instRepo.save(application);

		return ResponseEntity.ok(updatedFinalStatus);
	}



	@GetMapping("/instituteapplicationministry")
	public List<InstituteModel> getApprovedInstitutions(){
		return /*(List<StudentApplication>)*/instRepo.findByStatus(true);
	}



	@GetMapping("/candidates/{email}")
	public ResponseEntity<StudentModel> getStudentById(@PathVariable(value="email") String email)
			throws ResourceNotFoundException
	{
		StudentModel studentModel =stuRep.findByEmail(email).
				orElseThrow(() -> new ResourceNotFoundException
						("student Not Found for this Id: "+email));

		return ResponseEntity.ok().body(studentModel);     
	}


	@GetMapping("/getstudents")
	public List<StudentModel> getAllStudents(){
		return stuRep.findAll();
	}


	@GetMapping("/instituteapplications")
	public List<InstituteModel> getAllInstitutions(){
		return instRepo.findAll();
	}

	@GetMapping("/studentapplicationdetails")
	public List<StudentApplication> getStudentapplications()
	{
		return stuAppRepo.findAll();
	}

	@DeleteMapping("/delete-institute/{id}")
	public String deleteInstitution(@PathVariable String id)
	{
		instRepo.deleteByEmail(id);
		return "institute is deleted successfully";
	}

}
