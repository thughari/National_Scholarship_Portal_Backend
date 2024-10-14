package com.wipro.velocity.controller;
import java.util.List;
import com.wipro.velocity.repository.StudentApplicationRepository;
import com.wipro.velocity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.model.StudentApplication;
import com.wipro.velocity.model.StudentModel;

@RestController
@CrossOrigin(origins="https://thughari.github.io")
public class StudentController {

	@Autowired
	private StudentRepository stuRep;
	

	@PostMapping("/registerstudent")
	public String regstu(@RequestBody StudentModel sr)
	{
		stuRep.save(sr);
		return "student is registered successfully";

	}

	
	
	@GetMapping("/candidate/{email}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable String email)
    		throws ResourceNotFoundException
        {
                   StudentModel studentModel =stuRep.findByEmail(email).
                   orElseThrow(() -> new ResourceNotFoundException
                    ("student Not Found for this Id: "+email));
                   
                   return ResponseEntity.ok().body(studentModel);     
        }
	
	@GetMapping("/Studentapplication")
	  public List<StudentApplication> getAllApplications(){
	    return stuAppRepo.findAll();
	  }
	
	
	@PostMapping("/loginstudent")
	public Boolean loginStudent(@Validated @RequestBody StudentModel studentModel) throws ResourceNotFoundException {

		Boolean isLogin=false;
		String email=studentModel.getEmail();
		String password=studentModel.getPassword();

		 StudentModel stu = stuRep.findByEmail(email).orElseThrow(() ->
		new ResourceNotFoundException("Unknown Student"));
		 
		if(email.equals(stu.getEmail()) && password.equals(stu.getPassword()))
		{
			isLogin=true;
		}
		return isLogin;
	}

	
	
	//Student Applications
	
	@Autowired
	private StudentApplicationRepository stuAppRepo;
	
	@PostMapping("/applystudent")
	public String stuApply(@RequestBody StudentApplication stuApp)
	{
		stuAppRepo.save(stuApp);
		return "Application is submitted successfully";
	}
	
	//testing call
	@GetMapping
	public String testCall() {
		return "National Scholarship Portal works";
	}
	
}
