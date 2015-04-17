/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import database.DatabaseController;

/**
 *
 * @author Aya
 */
public class UserAndTeamController {
    private User user;
    private Team team;
    private DatabaseController database;
    
    /**
     * constructor that sets the User and Team
     * @param user
     * @param team
     */
    public UserAndTeamController(User user, Team team){
        this.user = user;
        this.team = team;
    }
    
    /**
     * create a new user and add to the database
     * @param name
     * @param isAdmin
     * @param id
     */
    public void createUser(String name, boolean isAdmin, int Id){
        User tmpUser = new User(name, isAdmin, Id);
        database.addUser(tmpUser);
        //TODO: add to database
    }
    //forward incoming User from client to GUI
    public void displayTask(Task task){
		//TODO: call method from GUI that displays the task in the GUI
    	
    }
    
    
    /**
     * find a user in the database by its userId and return user
     * @param userId
     * @return user returns the user for the given userId
     */
    public User findUser(int Id){
        //TODO: find user in database by userID
    	try {
			database.ShowResult(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return user;  
    }
    
    /**
     * edit an existing user and save the updated information to the database 
     * @param name
     * @param isAdmin
     * @param id
     */
    public void editUser(String name, boolean isAdmin, int Id){
        //TODO: save updated info to database
        editUser(name, isAdmin, Id);
        
        database.SaveResult();
    }

    /**
     * removes a user from the database
     * @param removeUserId
     */
    public void deleteUser(int userId){
        database.deleteUser(userId);
        //TODO: delete User from database
        
    }

    /**
     * adds a specific user to a specific team
     * @param userId the id of the user to be added to a team
     * @param teamId the id of the team that the user should be added to
     */
    public void addUserToTeam(int userId, int teamId ){
        database.SaveResult(userId, teamId);
        //TODO add user to team
        
    }
    public void createTeam(String name, int teamId){
        Team tmpTeam = new Team(name, teamId);
        //TODO: add to database
        database.SaveResult(tmpTeam);
    }    

    /**
     * find a team by its id
     * @param Id teamId
     * @return the team belonging to the Id
     */
    public Team findTeam(int teamId) {
    	try {
			database.ShowResult(teamId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return team;
    }

    /**
     * edits team information and adds the updated info to the database 
     * @param name
     * @param Id
     */
    public void editTeam(String name, int teamId){
        //TODO: add edited info to database/update database
        editTeam(name, teamId);
        
        database.SaveResult(teamId);
        
    }

    /**
     *
     * @param teamIdDelete the id of the team to be deleted
     */
    public void deleteTeam(int teamIdDelete){
        database.deleteTeam(teamIdDelete);
        //TODO: delete team from database based on the team Id
        
    }
     
    
    
}