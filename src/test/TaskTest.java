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
		task = new Task("2", "mini task", new String[]{"pall 1", "pall 2"}, null, "1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
