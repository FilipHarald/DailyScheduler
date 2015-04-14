/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import entities.Event;
import entities.EventController;
import entities.Task;
import entities.TaskController;
import entities.Team;
import entities.User;
import entities.UserAndTeamController;

import java.io.*;
import java.net.*;

/**
 *
 * @author Aya
 */
public class Client {
    private String userName;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket socket;
    
    private TaskController tc;
    private EventController ec;
    private UserAndTeamController utc;
    
    /*constructor: sets the ip, port and ID 
    *Also starts a new thread that maintains the connection to the server
    */
    public Client(String ip, int port) {
    	try{
    		socket = new Socket(ip, port);
    		ois = new ObjectInputStream(socket.getInputStream());
    		oos = new ObjectOutputStream(socket.getOutputStream());
    		
    	}catch(Exception e){
    		
    	}
    	new Listener().start();
    }


    //close connection to server
    public void disconnect() throws IOException {
        socket.close();
        
    }
    
    
    //send task to server
    public void sendTask(Task task){
    	
    	try{
    		oos.writeObject(task);
    		oos.flush();
    	}catch(IOException e){}
    }
    
    //send event to server
    public void sendEvent(Event event){
    	try{
    		oos.writeObject(event);
    		oos.flush();
    	}catch(IOException e){}
    }
    
    //send created user to server
    public void sendUser(User user){
    	try{
    		oos.writeObject(user);
    		oos.flush();
    	}catch(IOException e){}
    }
    
    //send team to server
    public void sendTeam(Team team){
    	try{
    		oos.writeObject(team);
    		oos.flush();
    	}catch(IOException e){}
    }
              
    
    /**
     * send userName to server via oos
     * incoming object can be instance of task, event, user or team.  
     * 
     */
    private class Listener extends Thread{
    	Object object;
    	
        public void run(){
            try{
                oos.writeUTF(userName);
                oos.flush();
                
                while(true){
                	object = ois.readObject();
                	
                	if(object instanceof Task){
                		
                		Task task = (Task) object;
                		tc.displayTask(task);
                		        
                	}else if(object instanceof Event){
                		Event event = (Event) object;
                		ec.displayEvent(event);
                		                		
                	}else if(object instanceof User){
                		User user = (User) object;
                		
                		
                	}else if(object instanceof Team){
                		Team team = (Team) object;
                		
                	}
                	
                }
            }catch(Exception e){}
        }
        
    }

    
}
