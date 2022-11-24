package com.wipro.velocity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.wipro.velocity.controller.InstituteController;
import com.wipro.velocity.model.InstituteModel;
import com.wipro.velocity.model.StudentModel;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class InstituteControllerTest {
	
	@Autowired
	private InstituteController instCtrl;
	
	@Test
	public void testInstituteRegister() {
		InstituteModel instMod=new InstituteModel();
		instMod.setInstitutionCode("SACET");
		instMod.setName("St.Ann's college");
		instMod.setEmail("sacet@ac.in");
		instMod.setPrincipleName("Gopal Rao");
		String res= instCtrl.reginst(instMod);
		assertEquals("institute is registered successfully",res);
	}
	
	@Test
	public void testInstituteLogin() {
		
		InstituteModel instMod=new InstituteModel();
		instMod.setEmail("bec@gmail.com");
		instMod.setPassword("Bec@123");
		assertEquals(instCtrl.loginInstitute(instMod),true);

	}
	
	@Test
	public void testGetAppliations() {
		assertNotEquals(instCtrl.getAllInstitutions(),0);
	}

}
