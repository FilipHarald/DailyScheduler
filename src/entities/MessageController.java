/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import database.Database;
import network.client.GUI.panels.MessagePanel;

/**
 *
 * @author Aya
 */
public class MessageController {
    private Message msg;
    private Database database;
    private MessagePanel msgPanel;
    
    public MessageController(Message msg){
        this.msg = msg;
    }
    
    public void createMessage(String title, String msg, String[] recipients, int id){
        Message tmpMessage = new Message(title, msg, recipients, id);
                
    }
    
    public void displayMessage(Message msg){
        msgPanel.displayMessage(msg);
    }
    
    public Message editMessage(){
        displayMessage();
        
        Message msg = new Message(null, null, null, 0);
        msg.getAuthor();
        msg.setTitle(msgPanel.getTitleText());
        msg.setMessage(msgPanel.getMessageText());
        msg.setRecipients(msgPanel.getRecipents());
        
        return msg;
    }
    
    public void deleteMessage(int msgIdDelete){
        database.deleteMessage(msgIdDelete);
        
    }
    
    
    
    
}
