package com.wipro.velocity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "studentapplication")
public class StudentApplication {
	
	@Id
	private String aadhar;
	private String phoneNumber;
	private String name;
	private String dob;
	private String email;
	private String religion;
	private String community;
	private String fatherName;
	private String motherName;
	private String annualIncome;
	private String institution;
	private String presentClass;
	private String presentClassYear;
	private String modeOfStudy;
	private String classStartDate;
	private String university;
	private String previousClass;
	private String previousClassYear;
	private String previousPercentage;
	private String tenthRollNo;
	private String tenthBoard;
	private String tenthYear;
	private String tenthPercentage;
	private String twelthRollNo;
	private String twelthBoard;
	private String twelthYear;
	private String twelthPercentage;
	private String admissionFee;
	private String tuitionFee;
	private String otherFee;
	private String isDisabled;
	private String typeOfDisability;
	private String disabilityPercenage;
	private String maritalStatus;
	private String parentsProfession;
	private String state;
	private String district;
	private String taluk;
	private String houseNo;
	private String streerNo;
	private String pincode;
	private String gender;
	private String scheme;
	private Boolean status=false;
	private Boolean finalStatus=false;

}
