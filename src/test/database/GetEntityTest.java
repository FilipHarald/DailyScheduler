package test.database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import database.DatabaseController;
import entities.*;

public class GetEntityTest {
	private User user;
	private Task task;
	private Team team;
	private Message message;
	private Event event;
	private DatabaseController db;
	
	@Before
	public void setUp() throws Exception {
		db = new DatabaseController();
//		user = new User("Testa Karlsson", false, "1234", 4);
	}

	@Test
	public void test() {
		try {
			user = (User) db.getEntity("User", 5);
			task = (Task) db.getEntity("Task", 1);
			team = (Team) db.getEntity("Team", 1);
			message = (Message) db.getEntity("Message", 1);
			event = (Event) db.getEntity("Event", 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("UserObj", "Testa Karlsson", user.getName());
		assertEquals("TaskObj", 1, task.getAuthor());
		assertEquals("TeamObj", 1, team.getId());
		assertEquals("MessageObj", 1, message.getId());
		assertEquals("EventObj", 1, event.getId());
		String [] str = task.getSubtasks();
		for (String s : str){
			System.out.println(s);
		}
//		assertEquals("TaskObj", 1, task.getSubtasks());
		
	}

}
