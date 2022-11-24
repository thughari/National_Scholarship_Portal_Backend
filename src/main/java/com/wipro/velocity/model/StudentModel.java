package com.wipro.velocity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentModel 
{
	
	@Id
	private String aadhar;
	
	private String name;
	private String email;
	private String stateofDomicile;
	private String dist;  
	private String dob;
	private String gender;
	private String mobileNumber;
	private String bankName;
	private String accountNo;
	private String ifsc;
	private String community;
	private String institutionCode;
	private String password;
	private Boolean status=false;
	
}
