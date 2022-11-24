package com.wipro.velocity;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import com.wipro.velocity.model.StudentModel;

public class StudentModelTest {

	StudentModel stuMod=new StudentModel("380183206828","Hari","haribabutatikonda3@gmailcom", "Andra Pradesh", "prakasham", "2000-08-28", "male", "9032805118", null, null, null, null, null, null, null);

	
	@Test
	  void testGetId() {
	    String expected="380183206828";
	    String actual=stuMod.getAadhar();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testGetEmail() {
	    
	    String expected="haribabutatikonda3@gmailcom";
	    String actual=stuMod.getEmail();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testGetName() {
	    String expected="Hari";
	    String actual=stuMod.getName();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testSetEmail() {
	    String email="tvs@gmail.com";
	    StudentModel stu=new StudentModel();
	    stu.setEmail(email);
	    assertEquals(stu.getEmail(), email);
	  }
	
	@Test
	  void testSetName() {
	    String name="uma";
	    StudentModel feedBack=new StudentModel();
	    feedBack.setName(name);
	    assertEquals(feedBack.getName(),name );
	  }
	
	@Test
	  void testGetstateofDomicile() {
	    String expected="Andra Pradesh";
	    String actual=stuMod.getStateofDomicile();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testGetDist() {
	    String expected="prakasham";
	    String actual=stuMod.getDist();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testGetDob() {
	    String expected="2000-08-28";
	    String actual=stuMod.getDob();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testGetGender() {
	    String expected="male";
	    String actual=stuMod.getGender();
	    assertEquals(expected, actual);
	  }
	
	@Test
	  void testGetMobileNo() {
	    String expected="9032805118";
	    String actual=stuMod.getMobileNumber();
	    assertEquals(expected, actual);
	  }

}
