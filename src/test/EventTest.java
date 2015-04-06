package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Event;

public class EventTest {
	private Event event;
	private Date theDate;
	
	@Before
	public void setUp() throws Exception {
		theDate = new Date();
		event = new Event("it is a dejt",theDate , 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("Descritpion", "it is a dejt", event.getDescription());
		assertEquals("Date", theDate, event.getDate());
	}

}
