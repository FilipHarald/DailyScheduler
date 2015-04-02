/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import java.io.IOException;
import network.client.GUI.GUIDailySchedulerApp;

/**
 *
 * @author Aya
 */
public class ClientController {
    private Client client;
    private GUIDailySchedulerApp GUI;
    private String ip;
    private int port;
    
    
    //constructor sets ip and port
    public ClientController(String serverIp, int port){
        ip = serverIp;
        this.port = port;
        
    }
    
    //start application
    public void startApplication(GUIDailySchedulerApp GUI, String ID){
        this.GUI = GUI;
        startClient(ID);
        
    }
    
    //start client for the user
     private void startClient(String ID){
        try{
            client = new Client(ip, port, ID);
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
   
        
    //2. DENNA METOD SKA ANROPAS AV LOGINFÖNSTRET
    public void logIn(String userName, String password){
    	if(userName.equals("test") && password.equals("12345")){
    		//3. HÄR SKA MAINFÖNSTRETSKAPAS
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
