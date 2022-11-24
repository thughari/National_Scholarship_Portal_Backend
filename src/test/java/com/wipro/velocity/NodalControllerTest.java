package com.wipro.velocity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.wipro.velocity.controller.NodalController;
import com.wipro.velocity.model.InstituteModel;
import com.wipro.velocity.model.NodalModel;
import com.wipro.velocity.model.StudentApplication;
import com.wipro.velocity.model.StudentModel;



@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class NodalControllerTest {
	
	@Autowired
	private NodalController nodCtrl;
	
	
	@Test
    public void testNodalLogin(){
		NodalModel nodMod=new NodalModel();
		nodMod.setNodalId("avinash@gmail.com");
		nodMod.setPassword("avi123");
		assertEquals(nodCtrl.loginNodal(nodMod),true);
	}
	
	@Test
	public void testGetInstituteAppliations() {
		assertNotEquals(nodCtrl.getAllInstitutions(),0);
	}
	
	@Test
	public void testGetStudentAppliations() {
		assertNotEquals(nodCtrl.getAllStudents(),0);
	}
	
	@Test
	public void testUpdateInstituteStatus() {
		
		InstituteModel instMod=new InstituteModel();
		instMod.setStatus(true);
		assertNotEquals(nodCtrl.updateStatus("BEC", instMod),true);
	}
	
	@Test
	public void testUpdateStudentStatus() {
		
		StudentApplication stuApp=new StudentApplication();
		stuApp.setStatus(true);
		assertNotEquals(nodCtrl.updateStatus("768870816385", stuApp),true);
	}

}
