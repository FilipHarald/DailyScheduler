/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aya
 */
public class TeamTest {
    
    public TeamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Team.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Team instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Team instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Team.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Team instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManagers method, of class Team.
     */
    @Test
    public void testGetManagers() {
        System.out.println("getManagers");
        Team instance = null;
        User[] expResult = null;
        User[] result = instance.getManagers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembers method, of class Team.
     */
    @Test
    public void testGetMembers() {
        System.out.println("getMembers");
        Team instance = null;
        User[] expResult = null;
        User[] result = instance.getMembers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeam method, of class Team.
     */
    @Test
    public void testGetTeam() {
        System.out.println("getTeam");
        Team instance = null;
        User[] expResult = null;
        User[] result = instance.getTeam();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMember method, of class Team.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        User member = null;
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.addMember(member);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addManager method, of class Team.
     */
    @Test
    public void testAddManager() {
        System.out.println("addManager");
        User manager = null;
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.addManager(manager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasMember method, of class Team.
     */
    @Test
    public void testHasMember() {
        System.out.println("hasMember");
        User member = null;
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.hasMember(member);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasManager method, of class Team.
     */
    @Test
    public void testHasManager() {
        System.out.println("hasManager");
        User manager = null;
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.hasManager(manager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeManager method, of class Team.
     */
    @Test
    public void testRemoveManager() {
        System.out.println("removeManager");
        User manager = null;
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.removeManager(manager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMember method, of class Team.
     */
    @Test
    public void testRemoveMember() {
        System.out.println("removeMember");
        User member = null;
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.removeMember(member);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
