package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Team;
import entities.User;

public class TeamTest {
	private Team team;

	@Before
	public void setUp() throws Exception {
		team = new Team("A team", 101);
		team.addManager(new User("Filip", false, 0));
		team.addManager(new User("Aya", false, 1));
		team.addMember(new User("Henrik", false, 2));
		team.addMember(new User("Fredrik", false, 3));
		team.addMember(new User("Adam", true, 4));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("ID", 101, team.getId());
		assertEquals("name ", "A team", team.getName());
		assertEquals("size", 5 , team.getSize());
		assertEquals("size", team.getTeam().length , team.getSize());
		assertEquals("members size", 3, team.getMembers().length);
		assertEquals("managers size", 2, team.getManagers().length);
		assertEquals("list size", 5, team.getTeam().length);
		team.addMember(new User("en till", false, 5));
		assertEquals("size after add", 6 , team.getSize());
		assertTrue(team.hasManager(new User("en till", false, 5)));
		team.addMember(new User("två till", false, 6));
		assertEquals("size after add", 7 , team.getSize());
	}

}
