/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import entities.User;

import java.io.*;
import java.net.*;

/**
 *
 * @author Aya
 */
public class Client {
    private String ID;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket socket;
    
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

    //returns the user ID 
    public int getID(User user){
        return user.getId();
    }

    //close connection to server
    public void disconnect() throws IOException {
        socket.close();
        
    }
    
    public boolean validate(String userName, String password) {
    	//Credentials need to be verfied on the server this is a TEMPORARY SOLUTION
    	return (userName.equals("test") && password.equals("1234"));
    }
    
    private class Listener extends Thread{
        public void run(){
            try{
                oos.writeUTF(ID);
                oos.flush();
                
            }catch(Exception e){}
        }
        
    }

    
}
