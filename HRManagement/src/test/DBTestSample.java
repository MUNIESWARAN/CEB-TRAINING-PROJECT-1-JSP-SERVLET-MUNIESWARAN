package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dao.RegistrationDao;
import com.dao.RegistrationDaoImp;
import com.model.Registration;

public class DBTestSample {

	RegistrationDaoImp obj;
	String email;
	String password;
	
	@Before
	public void setUp() throws Exception {
		obj = new RegistrationDaoImp();
		email="test@gmail.com";
		password="testuser";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateUser() {
		fail("Not yet implemented"); // TODO
		assertEquals("Success", false, obj.validateUser(email, password));
	}

}
