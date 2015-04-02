package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.User;

public class UserTest {
	
	
	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User("Filip Harald", true, 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("ID", 10, user.getId());
		assertEquals("name ", "Filip Harald", user.getName());
		assertTrue(user.isAdmin());
		user.setAdmin(false);
		assertFalse(user.isAdmin());
	}

}
