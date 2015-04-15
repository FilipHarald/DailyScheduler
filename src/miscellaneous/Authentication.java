/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.Serializable;

/**
 *
 * @author Aya
 */
public class Authentication implements Serializable{
    private String userName;
    private char[] password;
    
    public Authentication(String userName, char[] password){
        this.userName = userName;
        this.password = password;
        
    }
    
    public String getUserName(){
        return userName;
    }
    
    public char[] getPassword(){
        return password;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(char[] password){
        this.password = password;
    }
    
}
