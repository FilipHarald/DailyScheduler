/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import java.io.IOException;
import network.client.GUI.GUIDailySchedulerPanel;

/**
 *
 * @author Aya
 */
public class ClientController {
    private Client client;
    private GUIDailySchedulerPanel GUI;
    private String ip;
    private int port;
    
    
    //constructor sets ip and port
    public ClientController(){
    	//1. HÄR SKA LOGIN FÖNSTRET STARTAS
    }
    
    //2. DENNA METOD SKA ANROPAS AV LOGINFÖNSTRET
    public void logIn(String userName, String password){
    	if(userName.equals("test") && password.equals("12345")){
    		//3. HÄR SKA MAINFÖNSTRETSKAPAS
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //start client for the given username
    private void startClient(String username){
        try {
            client = new Client(ip, port, username);
        } catch (IOException ioe) {
            ioe.printStackTrace();
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
