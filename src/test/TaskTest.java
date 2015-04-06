package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Task;

public class TaskTest {
	private Task task;


	@Before
	public void setUp() throws Exception {
		task = new Task(101, "En del text", new String[]{"hej", "lol"}, null, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("author ID", 101, task.getAuthor());
		assertEquals("ID", 1, task.getId());
		assertEquals("Description", "En del text", task.getDescription());
		task.setDescription("En del texter");
		assertEquals("Description", "En del texter", task.getDescription());
	}

}
