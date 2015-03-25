package network.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;


public class Client {

    private String username;
    private String password;
    private Socket socket;
    private ObjectInputStream is;
    private ObjectOutputStream os;
   
   

    //constructor manages communication between client and server
    public Client(String ip, int port, String username, String password) throws IOException {
        socket = new Socket(ip, port);
        is = new ObjectInputStream(socket.getInputStream());
        os = new ObjectOutputStream(socket.getOutputStream());
        this.username = username;
        this.password = password;
        new Listener().start();

    }
    public String getUsername(){
        return username;
        
    }
    public String getPassword(){
        return password;

    }
    private class Listener extends Thread{
        public void run(){
            Object object;
        }
          
    }
    
    
    //closes the connection to server
    public void disconnect() throws IOException{
        socket.close();
    }
}
