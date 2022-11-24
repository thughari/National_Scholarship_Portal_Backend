package com.wipro.velocity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.wipro.velocity.controller.StudentController;
import com.wipro.velocity.model.StudentModel;


@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class StudentControllerTest {
	

	
	@Autowired
	private StudentController stuCtrl;
	
	@Test
	public void testRegisterstudent() {
		StudentModel stuMod=new StudentModel();
		stuMod.setAadhar("380183206828");
		stuMod.setName("Hari");
		stuMod.setEmail("thughari3@gmail.com");
		stuMod.setGender("male");
		String res= stuCtrl.regstu(stuMod);
		assertEquals("student is registered successfully",res);
	}
	
	@Test
    public void testStudentLogin(){
		StudentModel stuMod=new StudentModel();
		stuMod.setEmail("avinashkapudasi@gmail.com");
		stuMod.setPassword("avinash");
		stuCtrl.loginStudent(stuMod);
		assertEquals(stuCtrl.loginStudent(stuMod),true);
	}
	
	@Test
	public void testGetAppliations() {
		assertNotEquals(stuCtrl.getAllApplications(),0);
	}

}
