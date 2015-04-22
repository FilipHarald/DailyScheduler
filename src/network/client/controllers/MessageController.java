/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import database.DatabaseController;
import entities.Message;
import network.client.GUI.panels.MessagePanel;

/**
 *
 * @author Aya
 */
public class MessageController {
    private Message msg;
    private DatabaseController database;
    private MessagePanel msgPanel;
    
    public MessageController(Message msg){
        this.msg = msg;
    }
    
    public void createMessage(String name, String title, ArrayList<String> recipients, int id){
    	msg.getId();
        msg.setTitle(msgPanel.getTitle());
        msg.setMessage(msgPanel.getMessage());
        recipients = getRecipients();
    }
    
    public Message displayMessage(Message msg){
        msgPanel.displayMessage(msg);
    }
    
    public Message editMessage(ArrayList<String> recipients){
        displayMessage(msg);
      
        msg.getId();
        msg.setTitle(msgPanel.getTitle());
        msg.setMessage(msgPanel.getMessage());
        recipients = getRecipients();
       
        return msg;
    }
    
    public void deleteMessage(Object obj){
        try {
			database.deleteEntity(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
    
    private ArrayList<String> getRecipients (){
		String [] parts = msgPanel.getRecipients().split(",");
		if (parts !=  null){
			for (int i = 0; i < parts.length; i++){
				parts [i] = parts [i].trim();			}
		
			return new ArrayList <String>(Arrays.asList(parts));
		}
    	
    	return new ArrayList<String>(); 
    	
    }
    
    
    
    
}
