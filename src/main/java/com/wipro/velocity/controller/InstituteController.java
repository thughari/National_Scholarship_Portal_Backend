package com.wipro.velocity.controller;
import java.util.List;
import com.wipro.velocity.repository.*;
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
import com.wipro.velocity.model.*;

@RestController
@CrossOrigin(origins = "https://thughari.github.io")
public class InstituteController {

    @Autowired
    private InstituteRepository instrep;
    
    @PostMapping("/instituteregistration")
    public String reginst(@RequestBody InstituteModel ir)
    {
    	instrep.save(ir);
		return "institute is registered successfully";
    }
    
    
    //institution-login
    @PostMapping("/institutionlogin")
	public Boolean loginInstitute(@Validated @RequestBody InstituteModel institute) throws ResourceNotFoundException {

		Boolean isLogin=false;
		String email=institute.getEmail();
		String password=institute.getPassword();

		 InstituteModel inst = instrep.findByEmail(email).orElseThrow(() ->
		new ResourceNotFoundException("Unknown Institute"));
		 
		if(email.equals(inst.getEmail()) && password.equals(inst.getPassword()))
		{
			isLogin=true;
		}
		return isLogin;
	}
    
    @GetMapping("/institutes/{email}")
	public ResponseEntity<InstituteModel> getStudentById(@PathVariable(value="email") String email)
			throws ResourceNotFoundException
	{
		InstituteModel inst =instrep.findByEmail(email).
				orElseThrow(() -> new ResourceNotFoundException
						("student Not Found for this Id: "+email));

		return ResponseEntity.ok().body(inst);     
	}
   
    //for ministry
    
    @GetMapping("/Institutes")
    public List<InstituteModel> getAllInstitutions(){
        return instrep.findAll();
    }
    
  /*  @DeleteMapping("/delete-institute/{id}")
    public String deleteInstitution(@PathVariable String id)
    {
    	instrep.deleteById(id);
		return "institute is deleted successfully";
    }*/
}
