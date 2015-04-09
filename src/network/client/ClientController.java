/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import java.io.IOException;

import javax.swing.JFrame;

import network.client.GUI.ApplicationGUI;
import network.client.GUI.LoginGUI;

/**
 *
 * @author Aya
 */
public class ClientController {
    private Client client;
    private String ip;
    private int port;
    private LoginGUI loginWindow;
    private ApplicationGUI gui;
    
    
    //constructor sets ip and port
    public ClientController(String serverIp, int port){
        ip = serverIp;
        this.port = port;
        client = new Client(serverIp, port);
        
    }
    
    //start application
    public void startApplication(){
    	loginWindow = new LoginGUI(this);
    }
 
   
    public void login(String userName, String password){
    	if(client.validate(userName, password)){
    		loginWindow.close();
    		gui = new ApplicationGUI(userName, this);
    	}
    }

    
    //disconnect client when user logs out
    public void logout(){
        try{
            client.disconnect();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
