package test.database;

import static org.junit.Assert.*;
import miscellaneous.UsernameAndPwdPair;

import org.junit.Before;
import org.junit.Test;

import database.Database;

public class AuthenticateUserTest {
	private String username = "Testa Karlsson";
	private String password = "1234";
	private Database db;
	private UsernameAndPwdPair unP;

	@Before
	public void setUp() throws Exception {
		db = new Database();
		unP = new UsernameAndPwdPair(username, password);
	}

	@Test
	public void test() {
		assertTrue(db.authenticateUser(unP));
	}

}
