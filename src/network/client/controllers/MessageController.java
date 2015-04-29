/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import database.DatabaseController;
import entities.Message;
import miscellaneous.Updater;
import network.client.GUI.panels.MessagePanel;

/**
 *
 * @author Aya
 */
public class MessageController {
    private Message msg;
    private DatabaseController database;
    private MessagePanel msgPanel;
    private Updater up;
    private MessagePanel messagePanel;
    
    public MessageController(){
        messagePanel = new MessagePanel();
    }
    
    public void createMessage(String name, String title, ArrayList<String> recipients, int id){
        Message msg = new Message(name, title, recipients, id);
    	msg.getId();
        msg.setTitle(msgPanel.getTitle());
        msg.setMessage(msgPanel.getMessage());
        recipients = getRecipients();
        
        up.addMessage(msg);
    }
    
    public Message displayMessageList(Message msg){
        up.getMessages();
        return msg;
    }
    
     public void displayMessage(Message msg){
        messagePanel.displayMessage(msg);
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

	public void updatePanel(LinkedList<Message> messages) {
		messagePanel.updateMessageList(messages);
	}  
	
	public MessagePanel getPanel(){
		return messagePanel;
	}
    
}
