package test.database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import database.Database;
import entities.*;

public class GetEntityTest {
	private User user;
	private Task task;
	private Team team;
	private Database db;
	
	@Before
	public void setUp() throws Exception {
		db = new Database();
//		user = new User("Testa Karlsson", false, "1234", 4);
	}

	@Test
	public void test() {
		try {
			user = (User) db.getEntity("User", 4);
			task = (Task) db.getEntity("Task", 1);
			team = (Team) db.getEntity("Team", 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("UserObj", "Testa Karlsson", user.getName());
		assertEquals("TaskObj", "1", task.getAuthor());
		assertEquals("TeamObj", "lagett", team.getName());
	}

}
