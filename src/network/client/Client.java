package network.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;


public class Client {

    private String username;
    //private String password;
    private Socket socket;
    private ObjectInputStream is;
    private ObjectOutputStream os;
   
   

    //constructor manages communication between client and server
    public Client(String ip, int port, String username) throws IOException {
        socket = new Socket(ip, port);
        is = new ObjectInputStream(socket.getInputStream());
        os = new ObjectOutputStream(socket.getOutputStream());
        this.username = username;
        new Listener().start();

    }
    public String getUsername(){
        return username;
          
    }
    
    private class Listener extends Thread{
        public void run(){
            try{
                os.writeUTF(username);
                os.flush();
            
            while(true){
                try{
                    String s = (String) is.readObject();
                }
                catch(IOException e){
                    System.out.println("server has lost connection: " + e);
                }
            }
            }catch(Exception e){
                
            }
        }
          
    }
    
    
    //closes the connection to server
    public void disconnect() throws IOException{
        socket.close();
    }
}
