/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public class Message {
    private String authorId;
    private String title;
    private String msg;
    private ArrayList<String>recipients = new ArrayList<String>();
    private int id;
    
    public Message (String title, String msg, String[] recipients, int id){
        this.title = title;
        this.msg = msg;
        this.id = id;
        
    }

    public String getAuthor(){
        return authorId;
    }
                
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getMessage(){
        return msg;
    }
    
    public void setMessage(){
        this.msg = msg;
    }
    
    public ArrayList<String> getRecipients(){
        return recipients;
    }
    
    public void setRecipients(ArrayList<String> recipients){
        this.recipients = recipients;
        
    }
}
