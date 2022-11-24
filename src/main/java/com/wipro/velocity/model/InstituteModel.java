package com.wipro.velocity.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="instituteapplication")
public class InstituteModel 
{

	  private String institutionCategory;
	  private String name;
	  private String instState;
	  private String instDistrict;
	  @Id
	  private String institutionCode;
	  
	  private String email;
	  private String diseCode;
	  private String location;
	  private String institutionType;
	  private String affilatedUniversityState;
	  private String affilatedUniversityBoardName;
	  private String yearFromWhichAdmissionStarted;
	  private String password;
	  private String addressLine1;
	  private String addressLine2;
	  private String city;
	  private String state;
	  private String district;
	  private String pincode;
	  private String principleName;
	  private String telephone;
	  private Boolean status=false;
	  private Boolean finalStatus=false;
	  
}
