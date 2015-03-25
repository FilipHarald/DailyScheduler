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
    public ClientController(String serverIp, int port){
        ip = serverIp;
        this.port = port;
    }
    
    //start application 
    private void startApplication(GUIDailySchedulerPanel GUI, String username){
        this.GUI = GUI;
        startClient(username);
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
